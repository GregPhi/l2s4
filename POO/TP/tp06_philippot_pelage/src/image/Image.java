package image;

import image.*;
import image.color.*;

import java.util.*;
import java.io.InputStream;

public class Image implements ImageInterface {

  private final int width;
  private final int height;
  private final Pixel image[][];

  public Image(int w, int h){
    this.width = w;
    this.height = h;
    this.image = new Pixel[w][h];
    for (int i = 0; i < w; i++){
      for (int j = 0; j < h; j++){
        this.image[i][j] = new Pixel(GrayColor.WHITE);
      }
    }
  }

  public int getWidth(){
    return this.width;
  }

  public int getHeight(){
    return this.height;
  }

  public Pixel getPixel(int i, int j) throws UnknownPixelException{
    if ((this.width >=i ||this.height >= j) && (i < 0 && j < 0)){
      throw new UnknownPixelException("error getPixel");
    }
    return this.image[i][j];
  }

  public void setPixel(int i, int j, Pixel p) throws UnknownPixelException{
    if ((this.width > i || this.height > j) && (i >= 0 && j >= 0)){
      throw new UnknownPixelException("error setPixel");
    }
    this.image[i][j] = p;
  }

  public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException{
    if (this.width < x || this.height < y){
      throw new UnknownPixelException("erroer changeColorPixel");
    }
    this.image[x][y].setColor(color);
  }

  public Image edge(int threshold){
    Image img = new Image(this.width, this.height);
    for (int i = 0; i < this.width-1; i++){
      for (int j = 0; j < this.height-1; j++){
        Pixel pix = this.getPixel(i, j);
        if (((pix.colorDifference(this.getPixel(i, j+1)) > threshold) || (pix.colorDifference(this.getPixel(i+1,j)) > threshold))){
          img.changeColorPixel(i, j, GrayColor.BLACK);
        }else{
          img.changeColorPixel(i, j, GrayColor.WHITE);
        }
      }
    }
    return img;
  }

  public Image decreaseNbGrayLevels(int nbGrayLevels) {
    Image img = new Image(this.width, this.height);
    int scale = 256/nbGrayLevels;
    for (int i =0; i < this.width-1; i++){
      for (int j =0; j < this.height-1; j++){
        Pixel pix = this.getPixel(i,j);
        GrayColor color = new GrayColor(scale*(pix.getColor().getGrayLevel()/scale));
        img.changeColorPixel(i,j,color);
      }
    }
    return img;
  }

    // ======================================================================
    /** Reads a PGM image from file.
     * It is assumed that file respects the following PGM file syntax:
     *  <ul><li> first line with string "P2"</li>
     *  <li>second line : a comment</li>
     *  <li>one int for width <code>w</code>, one int for height<code>h</code></li>
     *  <li>one int for max gray level (not used here, we consider this level to be 255 in our images)</li>
     *  <li><code>w</code> x <code>h</code> integers between 0 and max (for us max=255) for each pixel</li></ul>
     *
     * @param fileName the name of the image file in PGM format
     * @return the image built from the file
     */
    public static Image initImagePGM(String fileName) {
        Scanner scan = new Scanner(Image.class.getResourceAsStream(fileName));

        scan.nextLine(); // line P2
        scan.nextLine(); // line comment
        // read width
        int width = scan.nextInt();
        // read height
        int height = scan.nextInt();
        // read max gray level (not used)
        scan.nextInt();
        // create an initially white image
        Image result = new Image(width, height);
        // rad pixels
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                result.changeColorPixel(y, x, new GrayColor(scan.nextInt()));
            }
        }
        return result;
    }


}
