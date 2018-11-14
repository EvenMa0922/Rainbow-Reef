package GameWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import GameObject.*;

public class GameWorld extends JPanel implements Observer, KeyListener {
  public static final int WIDTH = 680;
  public static final int HEIGHT = 480;
  public static final String block_life_location = "RainbowReefResources/Block_life.png";
  public static final String block_solid_location = "RainbowReefResources/Block_solid.png";
  public static final String block_split_location = "RainbowReefResources/Block_split.png";
  public static final String block_1_location = "RainbowReefResources/Block1.png";
  public static final String block_2_location = "RainbowReefResources/Block2.png";
  public static final String block_3_location = "RainbowReefResources/Block3.png";
  public static final String block_4_location = "RainbowReefResources/Block4.png";
  public static final String block_5_location = "RainbowReefResources/Block5.png";
  public static final String block_6_location = "RainbowReefResources/Block6.png";
  public static final String block_7_location = "RainbowReefResources/Block7.png";
  public static final String katch_location = "RainbowReefResources/Katch_strip24.png";
  public static final String pop_location = "RainbowReefResources/Pop_strip45.png";
  public static final String bigleg_location = "RainbowReefResources/Bigleg_small_strip24.png";
  public static final String lifebar_location = "RainbowReefResources/Katch_small.png";
  
  private GameClock clock;
  private Background background;
  private BackgroundLvl2 backgroundLvl2;
  private Wall wall;
  private Block block_life, block_solid, block_split, block_1, block_2, block_3, 
                block_4, block_5, block_6, block_7, lifebar;
  private Katch katch;
  private ArrayList<Integer> pressedKey;
  private Pop pop, popDuplicate;
  private int count;
  private MapInitialization map;
  private Bigleg bigleg;
  private boolean splited = false;
  
  public GameWorld() {
    this.clock = new GameClock();
    this.clock.addObserver(this);
    this.pressedKey = new ArrayList<Integer>();
    this.addKeyListener(this);
    this.setFocusable(true);
    this.count = 0;
    this.map = new MapInitialization();
    
    try {
      this.bigleg = new Bigleg( new Sprite( bigleg_location, 40, 40), this );
    } catch ( IOException e ) {
      System.err.println( "Failed to load bigleg." );
    }
    
    try {
      this.background = new Background();
      this.backgroundLvl2 = new BackgroundLvl2();
    } catch ( IOException exception ) {
      System.err.println( "Failed to load background." );
      exception.printStackTrace();
    }
    
    try {
      this.wall = new Wall();
    } catch ( IOException exception ) {
      System.err.println( "Failed to load wall." );
      exception.printStackTrace();
    }
    
    try {
      this.block_life = new Block( block_life_location );
      this.block_solid = new Block( block_solid_location );
      this.block_split = new Block( block_split_location );
      this.block_1 = new Block( block_1_location );
      this.block_2 = new Block( block_2_location );
      this.block_3 = new Block( block_3_location );
      this.block_4 = new Block( block_4_location );
      this.block_5 = new Block( block_5_location );
      this.block_6 = new Block( block_6_location );
      this.block_7 = new Block( block_7_location );
      this.lifebar = new Block( lifebar_location );
    } catch ( IOException exception ) {
      System.err.println( "Failed to load Blocks." );
    }
    
    try {
      this.katch = new Katch( new Sprite( katch_location, 80, 30 ), this, 280, 420 );
    } catch ( IOException exception ) {
      System.err.println( "Failed to load Katch." );
    }
    
    try {
      this.pop = new Pop( new Sprite( pop_location, 35, 35 ), this, this.katch );
    } catch ( IOException exception ) {
      System.err.println( "Failed to load Pop." );
    }
   
    this.clock.addObserver( pop );
    new Thread( this.clock ).start();
  }
  

  @Override
  public void update(Observable o, Object arg) {
    this.repaint(); 
  }
  
  @Override
  public void paintComponent( Graphics g ) {
    if ( MapInitialization.lvl == 1 ) {
      this.background.repaint( g );
    } else if ( MapInitialization.lvl == 2 ) {
      this.backgroundLvl2.repaint( g );
    }
    
    if ( MapInitialization.numBiglegs == 0 && MapInitialization.lvl == 1 ) {
      //MapInitialization.lvl++;
      this.map.setMapLvl2();
      this.pop.reset();
      this.katch.reset();
      this.pop.setStart(false);
      MapInitialization.lvl = 2;
    }
    
    for ( int i = 0; i < MapInitialization.life; i++ ) {
      this.lifebar.setX( 30+30*i);
      this.lifebar.setY( 440 );
      this.lifebar.repaint( g );
    }
    
    g.setColor(Color.black);
    g.drawString( "SCORE: " + MapInitialization.Score, 500, 440 );
    
    for ( int i = 0; i < 15; i++ ) {
      for ( int j = 0; j < 15; j++ ) {
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          this.block_split.setX( 20+i*40 );
          this.block_split.setY( 20+j*20 );
          this.block_split.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j]  == -2 ) {
          this.bigleg.setX( 20+i*40 );
          this.bigleg.setY( 20+j*20 );
          this.bigleg.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == -1 ) {
          this.block_solid.setX( 20+i*40 );
          this.block_solid.setY( 20+j*20 );
          this.block_solid.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          this.block_1.setX( 20+i*40 );
          this.block_1.setY( 20+j*20 );
          this.block_1.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          this.block_2.setX( 20+i*40 );
          this.block_2.setY( 20+j*20 );
          this.block_2.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          this.block_3.setX( 20+i*40 );
          this.block_3.setY( 20+j*20 );
          this.block_3.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          this.block_4.setX( 20+i*40 );
          this.block_4.setY( 20+j*20 );
          this.block_4.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          this.block_5.setX( 20+i*40 );
          this.block_5.setY( 20+j*20 );
          this.block_5.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          this.block_6.setX( 20+i*40 );
          this.block_6.setY( 20+j*20 );
          this.block_6.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          this.block_7.setX( 20+i*40 );
          this.block_7.setY( 20+j*20 );
          this.block_7.repaint( g );
        }
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          this.block_life.setX( 20+i*40 );
          this.block_life.setY( 20+j*20 );
          this.block_life.repaint( g );
        }
      }
    }
    
    for ( int i = 0; i < 32; i++ ) {
      this.wall.setX( i*20);
      this.wall.setY( 0 );
      this.wall.repaint( g );
    }
    for ( int j = 1; j < 24; j++ ) {
      this.wall.setX( 0 );
      this.wall.setY( j*20 );
      this.wall.repaint( g );
    }
    for ( int j = 1; j < 24; j++ ) {
      this.wall.setX( 620 );
      this.wall.setY( j*20 );
      this.wall.repaint( g );
    }
    
    if ( this.katch.getShow() ) {
      this.katch.repaint( g );
    }
    
    if ( this.pop.getShow() ) {
      this.pop.repaint( g );
    }
    
    this.control( pressedKey );
    
    if ( MapInitialization.split ) {
      try {
        if ( !splited ) {
          popDuplicate = new Pop( new Sprite( pop_location, 35, 35 ), this, this.katch, this.pop );
          splited = true;
          this.clock.addObserver(popDuplicate);
        }
        popDuplicate.repaint( g );
        if( this.popDuplicate.checkSidesCollidedBlock() ) {
          this.popDuplicate.reverseHorizontal();
          this.popDuplicate.setFrameOffset();
          
        } else if( this.popDuplicate.checkTopCollidedBlock() ) {
          //this.popDuplicate.reverseHorizontal();
          //this.popDuplicate.setFrameOffset();
          this.popDuplicate.reverseG();
        }
        
        if( this.popDuplicate.checkCollidedSidesWall() ) {
          this.popDuplicate.reverseHorizontal();
          this.popDuplicate.setFrameOffset();
        }
        
        
        
        if( this.popDuplicate.checkCollideTop() ) this.popDuplicate.reverseG();
        
        if( this.popDuplicate.checkSidesCollidedBlock() ) {
          
          this.popDuplicate.reverseHorizontal();
          this.popDuplicate.setFrameOffset();
        } else if ( this.popDuplicate.checkBotCollidedBlock() ) {
          this.popDuplicate.reverseG(); 
        }
        
        if( this.popDuplicate.checkCollidekatchSides( this.katch ) ) {
          this.popDuplicate.reverseHorizontal();
        } else if ( this.popDuplicate.checkCollideKatch( this.katch ) ) {
          this.popDuplicate.reverseG();
          this.count++;
          if( this.count % 10 == 0 ) this.popDuplicate.speedUp();
          this.popDuplicate.setHorizontalOffset( this.katch );
        } 
        
        else if ( this.popDuplicate.checkFell( this.katch ) ) {
          //this.popDuplicate.setX(-100);
          //this.popDuplicate.setY(-100);
          this.clock.deleteObserver(popDuplicate);
          //popDuplicate = null;
          this.splited = false;
          MapInitialization.life++;
          MapInitialization.split = false;
        }
      } catch ( IOException e ) {
        System.err.println( "Faile to load pop duplicate " );
      }
     
    }
    
    //if( this.pop.checkCollidedSides() ) System.out.println("111");
    if( this.pop.checkSidesCollidedBlock() ) { 
      this.pop.reverseHorizontal();
      this.pop.setFrameOffset();
    } else if( this.pop.checkTopCollidedBlock() ) {    
      this.pop.reverseG();
    }
    
    if( this.pop.checkCollidedSidesWall() ) {
      this.pop.reverseHorizontal();
      this.pop.setFrameOffset();
    }
    
    
    
    if( this.pop.checkCollideTop() ) this.pop.reverseG();
    
    if( this.pop.checkSidesCollidedBlock() ) {
      this.pop.reverseHorizontal();
      this.pop.setFrameOffset();
    } else if ( this.pop.checkBotCollidedBlock() ) {
      this.pop.reverseG();
    }
    
    if( this.pop.checkCollidekatchSides( this.katch ) ) {
      //this.pop.reverseG();
//      this.count++;
//      if( this.count % 10 == 0 ) this.pop.speedUp();
//      this.pop.setHorizontalOffestSides( this.katch );
      this.pop.reverseHorizontal();
    }
    
    else if ( this.pop.checkCollideKatch( this.katch ) ) {
      this.pop.reverseG();
      this.count++;
      if( this.count % 10 == 0 ) this.pop.speedUp();
      this.pop.setHorizontalOffset( this.katch );
    } 
    
    else if ( this.pop.checkFell( this.katch ) ) {
      this.pop.reset();
      this.katch.reset();
      this.pop.setStart(false);
      MapInitialization.life--;
    }
    
    if ( MapInitialization.life == 0 ) {
      this.clock.deleteObserver(this);
      try {
        BackgroundEnd end = new BackgroundEnd();
        super.paintComponent( g );
        end.repaint( g );
      } catch ( IOException e) {
        System.err.println( "Faile to load ending image." );
      }     
    }
    
    if ( MapInitialization.numBiglegs == 0 && MapInitialization.lvl == 2 ) {
      this.clock.deleteObserver(this);
      try {
        BackgroundEnd end = new BackgroundEnd();
        super.paintComponent( g );
        end.repaint( g );
      } catch ( IOException e) {
        System.err.println( "Faile to load ending image." );
      }    
    }
  }
  
  
  public void control( ArrayList<Integer> arr ) {
    for ( Integer key : arr ) {
      if ( key == 37 ) {
        this.katch.setX( this.katch.getX()-8 );
        if ( this.katch.checkCollision() ) {
          this.katch.setX( this.katch.getX()+8 );
        }
      }
      if ( key == 39 ) {
        this.katch.setX( this.katch.getX()+8 );
        if ( this.katch.checkCollision() ) {
          this.katch.setX( this.katch.getX()-8 );
        }
      }
      if ( key == 32 ) {
        this.pop.setStart( true );
      }
      if ( key == 67 ) {
        
        MapInitialization.numBiglegs = 1; 
        MapInitialization.wallLocation[3][0] = 0;
        MapInitialization.wallLocation[11][0] = 0;
        MapInitialization.wallLocation[3][1] = 0;
        MapInitialization.wallLocation[11][1] = 0;
      }
    }
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    pressedKey.remove( new Integer( e.getKeyCode() ) );
  }


  @Override
  public void keyPressed(KeyEvent e) {
    if ( !pressedKey.contains( e.getKeyCode() ) ) {
      pressedKey.add( new Integer(e.getKeyCode()) );
    }   
  } 

  @Override
  public void keyTyped(KeyEvent e) {}
}
