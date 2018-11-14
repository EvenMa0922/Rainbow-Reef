package GameObject;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Pop extends GameObject implements Observer {
  private int currentFrame;
  private Sprite sprite;
  private ImageObserver observer;
  private int width, height;
  private int gravity;
  private boolean fell;
  private boolean start;
  protected double horizontalOffset;
  protected int frameOffset;
  
  public Pop ( Sprite sprite, ImageObserver o, Katch katch ) throws IOException {
    this.setX( 302 );
    this.setY( 384 );
    this.currentFrame = 0;
    this.sprite = sprite;
    this.observer = o;
    this.width = sprite.getFrame(0).getWidth();
    this.height = sprite.getFrame(0).getHeight();
    this.setShow( true );
    this.gravity = -5;
    this.fell = false;
    this.start = false;
    this.horizontalOffset = 0;
    this.frameOffset = 1;
  }
  
  public Pop ( Sprite sprite, ImageObserver o, Katch katch, Pop pop ) throws IOException {
    this.setX( pop.getX() );
    this.setY( pop.getY() );
    this.currentFrame = pop.getCurrentFrame();
    this.sprite = pop.getSprite();
    this.observer = o;
    this.width = sprite.getFrame(0).getWidth();
    this.height = sprite.getFrame(0).getHeight();
    this.setShow( true );
    this.gravity = -5;
    this.fell = false;
    this.start = true;
    this.horizontalOffset = pop.horizontalOffset;
    this.frameOffset = pop.frameOffset;
  }
  
  public boolean checkBotCollidedBlock() {
    if ( this.gravity < 0 ) {
      return false;
    }
    boolean result = false;
    double x0, y0, x1, y1, x2, y2;
    int i, j;
    x0 = (this.getX() + 18)-20;
    x1 = (this.getX() + 18)-20;
    x2 = (this.getX() + 18)-20;
    y0 = (this.getY())+15;
    y1 = (this.getY())+15;
    y2 = (this.getY())+15;
    
    if ( y0 > 435 ) return false;
    
    if ( x2 > 599 ) x2 = 599;
    if ( x1 > 599 ) x1 = 599;
    if ( x0 > 599 ) x0 = 599;
    
    i = (int)x1 / 40;
    j = (int)y1 / 20;
    if ( MapInitialization.wallLocation[i][j] != 0 ) {
      result = true;
      if ( MapInitialization.wallLocation[i][j] == 8 ) {
        MapInitialization.life++;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 7 ) {
        MapInitialization.Score += 700;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 6 ) {
        MapInitialization.Score += 600;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 5 ) {
        MapInitialization.Score += 500;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 4 ) {
        MapInitialization.Score += 400;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 3 ) {
        MapInitialization.Score += 300;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 2 ) {
        MapInitialization.Score += 200;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 1 ) {
        MapInitialization.Score += 100;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -2 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j+1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -3 ) {
        MapInitialization.split = true;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -4 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j-1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }    
    }  
    i = (int)x0 / 40;
    j = (int)y0 / 20;
    if ( MapInitialization.wallLocation[i][j] != 0 ) {
      result = true;
      if ( MapInitialization.wallLocation[i][j] == 8 ) {
        MapInitialization.life++;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 7 ) {
        MapInitialization.Score += 700;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 6 ) {
        MapInitialization.Score += 600;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 5 ) {
        MapInitialization.Score += 500;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 4 ) {
        MapInitialization.Score += 400;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 3 ) {
        MapInitialization.Score += 300;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 2 ) {
        MapInitialization.Score += 200;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 1 ) {
        MapInitialization.Score += 100;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -2 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j+1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -3 ) {
        MapInitialization.split = true;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -4 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j-1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }    
    }  
    i = (int)x2 / 40;
    j = (int)y2 / 20;
    if ( MapInitialization.wallLocation[i][j] != 0 ) {
      result = true;
      if ( MapInitialization.wallLocation[i][j] == 8 ) {
        MapInitialization.life++;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 7 ) {
        MapInitialization.Score += 700;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 6 ) {
        MapInitialization.Score += 600;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 5 ) {
        MapInitialization.Score += 500;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 4 ) {
        MapInitialization.Score += 400;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 3 ) {
        MapInitialization.Score += 300;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 2 ) {
        MapInitialization.Score += 200;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 1 ) {
        MapInitialization.Score += 100;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -2 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j+1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -3 ) {
        MapInitialization.split = true;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -4 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j-1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }    
    }
    return result;
  }
  
  public boolean checkSidesCollidedBlock() {
    boolean result = false;
    double x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;
    int i, j;
    x0 = (this.getX())-15;
    x1 = (this.getX())-15;
    x2 = (this.getX())-15;
    x3 = (this.getX())+10;
    x4 = (this.getX())+10;
    x5 = (this.getX())+10;
    y0 = (this.getY()+4)-20;
    y1 = (this.getY()+18)-20;
    y2 = (this.getY()+31)-20;
    y3 = (this.getY()+4)-20;
    y4 = (this.getY()+18)-20;
    y5 = (this.getY()+31)-20;
    
    if ( y0 > 470 ) return false;
    if ( x1 > 599 ) x1 = 599;
    if ( x4 > 599 ) x4 = 599;
    if ( x0 > 599 ) x0 = 599;
    if ( x3 > 599 ) x3 = 599;
    if ( x2 > 599 ) x2 = 599;
    if ( x5 > 599 ) x5 = 599;
    
    if ( this.horizontalOffset < 0 ) {
      i = (int)x1 / 40;
      j = (int)y1 / 20;
      if ( MapInitialization.wallLocation[i][j] != 0 ) {
        result = true;
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          MapInitialization.life++;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          MapInitialization.Score += 700;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          MapInitialization.Score += 600;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          MapInitialization.Score += 500;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          MapInitialization.Score += 400;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          MapInitialization.Score += 300;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          MapInitialization.Score += 200;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          MapInitialization.Score += 100;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -2 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j+1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          MapInitialization.split = true;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -4 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j-1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }   
      }
      
      i = (int)x0 / 40;
      j = (int)y0 / 20;
      if ( MapInitialization.wallLocation[i][j] != 0 ) {
        result = true;
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          MapInitialization.life++;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          MapInitialization.Score += 700;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          MapInitialization.Score += 600;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          MapInitialization.Score += 500;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          MapInitialization.Score += 400;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          MapInitialization.Score += 300;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          MapInitialization.Score += 200;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          MapInitialization.Score += 100;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -2 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j+1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          MapInitialization.split = true;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -4 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j-1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }   
      }      
      i = (int)x2 / 40;
      j = (int)y2 / 20;
      if ( MapInitialization.wallLocation[i][j] != 0 ) {
        result = true;
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          MapInitialization.life++;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          MapInitialization.Score += 700;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          MapInitialization.Score += 600;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          MapInitialization.Score += 500;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          MapInitialization.Score += 400;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          MapInitialization.Score += 300;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          MapInitialization.Score += 200;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          MapInitialization.Score += 100;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -2 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j+1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          MapInitialization.split = true;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -4 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j-1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }   
      }
    }
    if ( this.horizontalOffset > 0 ) {
    i = (int)x4 / 40;
    j = (int)y4 / 20;
      if ( MapInitialization.wallLocation[i][j] != 0 ) {
        result = true;
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          MapInitialization.life++;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          MapInitialization.Score += 700;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          MapInitialization.Score += 600;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          MapInitialization.Score += 500;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          MapInitialization.Score += 400;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          MapInitialization.Score += 300;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          MapInitialization.Score += 200;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          MapInitialization.Score += 100;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -2 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j+1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          MapInitialization.split = true;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -4 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j-1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }   
      }
      
      i = (int)x3 / 40;
      j = (int)y3 / 20;
      if ( MapInitialization.wallLocation[i][j] != 0 ) {
        result = true;
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          MapInitialization.life++;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          MapInitialization.Score += 700;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          MapInitialization.Score += 600;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          MapInitialization.Score += 500;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          MapInitialization.Score += 400;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          MapInitialization.Score += 300;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          MapInitialization.Score += 200;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          MapInitialization.Score += 100;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -2 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j+1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          MapInitialization.split = true;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -4 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j-1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }   
      }
      i = (int)x5 / 40;
      j = (int)y5 / 20;
      if ( MapInitialization.wallLocation[i][j] != 0 ) {
        result = true;
        if ( MapInitialization.wallLocation[i][j] == 8 ) {
          MapInitialization.life++;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 7 ) {
          MapInitialization.Score += 700;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        } 
        if ( MapInitialization.wallLocation[i][j] == 6 ) {
          MapInitialization.Score += 600;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 5 ) {
          MapInitialization.Score += 500;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 4 ) {
          MapInitialization.Score += 400;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 3 ) {
          MapInitialization.Score += 300;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 2 ) {
          MapInitialization.Score += 200;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == 1 ) {
          MapInitialization.Score += 100;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -2 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j+1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -3 ) {
          MapInitialization.split = true;
          MapInitialization.wallLocation[i][j] = 0;
          return result;
        }
        if ( MapInitialization.wallLocation[i][j] == -4 ) {
          MapInitialization.Score += 1000;
          MapInitialization.wallLocation[i][j] = 0;
          MapInitialization.wallLocation[i][j-1] = 0;
          MapInitialization.numBiglegs--;
          return result;
        }   
      }
    }
    return result;
  }
  
  public boolean checkTopCollidedBlock() {
    if( this.gravity > 0 ) {
      return false;
    }
    boolean result = false;
    double x0, y0, x1, y1, x2, y2;
    int i, j;
    x0 = (this.getX()+9)-20;
    x1 = (this.getX()+18)-20;
    x2 = (this.getX()+24)-20;
    y0 = (this.getY()-20);
    y1 = (this.getY()-20);
    y2 = (this.getY()-20);
    
    
    if ( x2 > 599 ) x2 = 599;
    if ( x1 > 599 ) x1 = 599;
    if ( x0 > 599 ) x0 = 599;
    
    i = (int)x1 / 40;
    j = (int)y1 / 20;
    if ( MapInitialization.wallLocation[i][j] != 0 ) {
      result = true;
      if ( MapInitialization.wallLocation[i][j] == 8 ) {
        MapInitialization.life++;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 7 ) {
        MapInitialization.Score += 700;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 6 ) {
        MapInitialization.Score += 600;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 5 ) {
        MapInitialization.Score += 500;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 4 ) {
        MapInitialization.Score += 400;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 3 ) {
        MapInitialization.Score += 300;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 2 ) {
        MapInitialization.Score += 200;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 1 ) {
        MapInitialization.Score += 100;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -2 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j+1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -3 ) {
        MapInitialization.split = true;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -4 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j-1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }    
    }  
    i = (int)x0 / 40;
    j = (int)y0 / 20;
    if ( MapInitialization.wallLocation[i][j] != 0 ) {
      result = true;
      if ( MapInitialization.wallLocation[i][j] == 8 ) {
        MapInitialization.life++;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 7 ) {
        MapInitialization.Score += 700;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 6 ) {
        MapInitialization.Score += 600;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 5 ) {
        MapInitialization.Score += 500;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 4 ) {
        MapInitialization.Score += 400;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 3 ) {
        MapInitialization.Score += 300;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 2 ) {
        MapInitialization.Score += 200;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 1 ) {
        MapInitialization.Score += 100;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -2 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j+1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -3 ) {
        MapInitialization.split = true;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -4 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j-1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }    
    }  
    i = (int)x2 / 40;
    j = (int)y2 / 20;
    if ( MapInitialization.wallLocation[i][j] != 0 ) {
      result = true;
      if ( MapInitialization.wallLocation[i][j] == 8 ) {
        MapInitialization.life++;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 7 ) {
        MapInitialization.Score += 700;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      } 
      if ( MapInitialization.wallLocation[i][j] == 6 ) {
        MapInitialization.Score += 600;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 5 ) {
        MapInitialization.Score += 500;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 4 ) {
        MapInitialization.Score += 400;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 3 ) {
        MapInitialization.Score += 300;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 2 ) {
        MapInitialization.Score += 200;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == 1 ) {
        MapInitialization.Score += 100;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -2 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j+1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -3 ) {
        MapInitialization.split = true;
        MapInitialization.wallLocation[i][j] = 0;
        return result;
      }
      if ( MapInitialization.wallLocation[i][j] == -4 ) {
        MapInitialization.Score += 1000;
        MapInitialization.wallLocation[i][j] = 0;
        MapInitialization.wallLocation[i][j-1] = 0;
        MapInitialization.numBiglegs--;
        return result;
      }    
    }  
    return result;
  }
  
  public boolean checkCollidedSidesWall() {
    boolean result = false;
    if ( this.getX() < 21 || this.getX()+35 > 619 ) result = true;
    return result;
  }
  
  public boolean checkFell( Katch katch ) {
    boolean result = false;
    if ( (((this.getX()+35 > katch.getX()-8 && this.getX()+35 < katch.getX()) || 
        (this.getX() < katch.getX()+88 && this.getX() > katch.getX()+80)) && this.getY() > 405 ) || this.getY() > 480 ) 
    //if ( this.getY() > 480 )  
      result = true;
    
    return result;
  }
  
  public boolean checkCollidekatchSides( Katch katch ) {
    boolean result = false;
    if ( (((this.getX()+35 > katch.getX()-8 && this.getX()+35 < katch.getX()) || 
        (this.getX() < katch.getX()+88 && this.getX() > katch.getX()+80)) && ( this.getY() > 385 && this.getY() <= 405 ))){
      result = true;
    }
//    double x1, y1, x2, y2;
//    x1 = this.getX();
//    x2 = this.getX()+35;
//    y1 = this.getY();
//    y2 = this.getY();
//    if ( x2 >= katch.getX()-4 && x2 <= katch.getX() && ( y2 > 384 && y2 < 400 ) ) {
//      return result = true;
//    }
//    if ( x1 >= katch.getX()+80 && x1 <= katch.getX()+84 && ( y2 > 384 && y2 < 400) ) {
//      return result = true;
//    }
    return result;
  }
  
  public boolean checkCollideKatch( Katch katch ) {
    boolean result = false;
    if ( (this.getX()+17.5 > katch.getX()-17.5 && this.getX()+17.5 < katch.getX()+97.5 ) && this.getY() > 385 )
      result = true;  
    return result;
  }
  
  public boolean checkCollideTop() {
    boolean result = false;
    if ( this.getY() <= 20 ) result = true;
    return result;
  }
  
  public void speedUp() { 
    if ( this.gravity > 0) this.gravity++; 
    if ( this.gravity < 0) this.gravity--;
    if ( this.gravity < -10 ) this.gravity = -10;
    if ( this.gravity > 10 ) this.gravity = 10;
  }
  
//  public void setHorizontalOffestSides( Katch katch ) {
//    double x = this.getX();
//    double o = katch.getX();
//    if ( x < o + 40 ) {
//      this.horizontalOffset = ( Math.abs(this.gravity))*Math.tan(0.69)*-1;
//    } else {
//      this.horizontalOffset = ( Math.abs(this.gravity))*Math.tan(0.69);
//    }
//  }
  
  public void setHorizontalOffset( Katch katch ) { 
    double x = this.getX()+17.5;
    double o = katch.getX()+40;
    if ( x < o ) {
      this.horizontalOffset = (Math.abs(this.gravity))*Math.tan( (x-o)*(x-o)/1600*0.60 )*-1;
      //if( this.horizontalOffset < this.gravity ) this.horizontalOffset = this.gravity;
    } else {
      this.horizontalOffset = (Math.abs(this.gravity))*Math.tan( (x-o)*(x-o)/1600*0.60);
      //if( this.horizontalOffset > this.gravity ) this.horizontalOffset = this.gravity*-1;
    }  
  }
  
  public void reverseHorizontal() { this.horizontalOffset *= -1; }
  
  public void reverseG() { this.gravity *= -1; }
  
  public void setStart( boolean bool ) { this.start = bool; } 
  
  public boolean getStart() { return this.start; }
  
  public boolean getFell() { return this.fell; }
  
  public void setFell( boolean bool ) { this.fell = bool; }
  
  public void reset() { this.setX( 302 ); this.setY( 384 ); this.start = false; 
                        this.horizontalOffset = 0; this.gravity = -5;
                        this.currentFrame = 0;
  }
  
  public void setFrameOffset() { this.frameOffset *= -1; }
  
  public int getWidth() { return this.width; }
  
  public int getHeight() { return this.height; }
  
  public int getCurrentFrame() { 
//    if ( currentFrame < 0) {
//      currentFrame = 45;
//    }
    return currentFrame; 
  }
  
  public Sprite getSprite() { return this.sprite; }

  public void repaint(Graphics graphics) {
    graphics.drawImage(
        this.sprite.getFrame( currentFrame ), (int)getX(), (int)getY(), observer);  
  }

  @Override
  public void update(Observable o, Object arg) {
    int temp;
    double temp1;
    if ( this.start ) {
      temp1 = this.gravity*(this.getY()/480);
      if( temp1 < 2 && temp1 > 0 ) temp1 = 2;
      if( temp1 < 0 && temp1 > -2 ) temp1 = -2;
      this.setY( this.getY() + temp1 );
      this.setX( this.getX() + this.horizontalOffset );
      temp = this.currentFrame + this.frameOffset;
      if ( temp == -1 ) temp = 44;
      this.currentFrame = temp % 45;
      
    }
    
  }
  
}
