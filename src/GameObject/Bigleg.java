package GameObject;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Bigleg extends GameObject implements Observer {
  private int currentFrame;
  private Sprite sprite;
  private ImageObserver observer;
  private int width, height;
  private int frameCount = 0;
  
  public Bigleg( Sprite sprite, ImageObserver o ) throws IOException {
    this.sprite = sprite;
    this.observer = o;
    this.width = sprite.getFrame(0).getWidth();
    this.height = sprite.getFrame(0).getHeight();
    this.setShow( true );
  }
  
  public int getWidth() { return this.width; }
  
  public int getHeight() { return this.height; }
  
  public int getCurrentFrame() { 
    if ( currentFrame <= 0) {
      currentFrame = 60;
    }
    return currentFrame; 
  }
  
  public Sprite getSprite() { return this.sprite; }

  public void repaint(Graphics graphics) {
    graphics.drawImage(
        this.sprite.getFrame( currentFrame ), (int)getX(), (int)getY(), observer);  
  }

  @Override
  public void update( Observable o, Object arg ) {
    this.currentFrame = (this.currentFrame++) % 24;
  }

}
