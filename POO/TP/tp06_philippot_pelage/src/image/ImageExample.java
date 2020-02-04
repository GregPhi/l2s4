package image;

import image.color.*;
import image.*;

/**
 *
 *
 *
 *
 */

public class ImageExample{
  public static void main(String[] args){
    Image img = new Image(100, 200);
    GrayColor color1 = new GrayColor(64);
    GrayColor color2 = new GrayColor(230);
    for (int i=1; i<=20; i++){
      for (int j=1; j<=30; j++){
        try{
          img.changeColorPixel(i+10, j+30, GrayColor.BLACK);
        }catch(UnknownPixelException e){

        }
      }
    }
    for (int i=1; i<=20; i++){
      for (int j=1; j<=50; j++){
        try{
          img.changeColorPixel(i+50, j+50, color1);
        }catch(UnknownPixelException e){

        }
      }
    }
    for (int i=1; i<=20; i++){
      for (int j=1; j<=50; j++){
        try{
          img.changeColorPixel(i+20, j+110, color2);
        }catch(UnknownPixelException e){

        }
      }
    }
    ImageDisplayer dis = new ImageDisplayer();
    dis.display(img, "A picture");
    Image img2 = img.edge(50);
    dis.display(img2, "A edge picture", 10+img.getWidth(), 100);
  }
}
