package GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Sprite {
  private int tileWidth, tileHeight;
  private String spriteFile;

  private BufferedImage[] images;

  public Sprite( String spriteFile, int tileWidth, int tileHeight ) throws IOException {
    this.spriteFile = spriteFile;
    this.tileWidth = tileWidth;
    this.tileHeight = tileHeight;
    this.loadImages();
  }

  private void loadImages() throws IOException {
    BufferedImage image = ImageIO.read( new File( spriteFile ));

    this.images = new BufferedImage[ image.getWidth() / tileWidth ];

    for( int index = 0; index < this.images.length; index++ ) {
      this.images[ index ] = image.getSubimage(
        index * this.tileWidth, 0, this.tileWidth, this.tileHeight
      );
    }
  }

  public BufferedImage getFrame( int frame ) {
    if ( frame == 60 ) frame = 0;
    if ( frame == 45 ) frame = 0;
    if ( frame == 24 ) frame = 0;
    return this.images[ frame ];
  }

  public int frameCount() {
    return this.images.length;
  }
}
