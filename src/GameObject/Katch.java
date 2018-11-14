package GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import GameWorld.*;


public class Katch extends GameObject {
  private Sprite sprite;
  private int currentFrame;
  private ImageObserver observer;
  private int width, height;
  private int life = 3; 
  
  public Katch( Sprite sprite, double x, double y ) throws IOException {
    this( sprite, null, x, y );
  }
  
  public Katch( Sprite sprite, ImageObserver o, double x, double y) throws IOException {
    this.sprite = sprite;
    this.observer = o;
    this.currentFrame = 0;
    this.setX(x);
    this.setY(y);
    this.setShow(true);
    this.height = sprite.getFrame(0).getHeight();
    this.width = sprite.getFrame(0).getWidth();
  }
  
  public void reset() { this.setX( 280 );}
  
  public boolean checkCollision() {
    boolean collided = false;
    double x0, x1;
    x0 = this.getX();
    x1 = this.getX() + 80;
    
    if ( x0 <= 20 ) { collided = true; }
    if ( x1 >= 620 ) { collided = true; }
    
    return collided;
  }
  
  public int getWidth() { return this.width; }
  
  public int getHeight() { return this.height; }
  
  public int getCurrentFrame() { return currentFrame; }
  
  public int getLife() { return life; }
  
  public void setLife( int demage ) { life -= demage; }
  
  public void setCurrentFrame( int num ) { this.currentFrame = num; }
  
  public Sprite getSprite() { return this.sprite; }

  public void repaint(Graphics graphics) {
    graphics.drawImage(
        this.sprite.getFrame( currentFrame ), (int)getX(), (int)getY(), observer);  
  }
}
