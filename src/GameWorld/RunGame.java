package GameWorld;

import javax.swing.*;
import java.io.IOException;


public class RunGame extends JFrame {
  private GameWorld gameworld;
  
  public RunGame() throws IOException {
    this.gameworld = new GameWorld();
    this.add( this.gameworld );
    
    //pack();
    setTitle( "RainbowReef" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    //setLocationRelativeTo(null);
    setSize(640, 480);
    setVisible( true );
    setResizable( false );
  }
  

  
  public static void main( String[] args ) {
    try {
      new RunGame();
    } catch( IOException e ) {
      e.printStackTrace();
    }
  }

}
