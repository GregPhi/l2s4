package image;

import image.*;
import image.color.*;

public class ImageMain{
  public static void main(String[] args){
    ImageDisplayer imgDisplay = new ImageDisplayer();
    Image img = Image.initImagePGM(args[0]);
    imgDisplay.display(img, "picture");
    if (args.length >= 2){
      int edge = Integer.parseInt(args[1]);
      Image imgedge = img.edge(edge);
      imgDisplay.display(imgedge, "edge picture", 100+img.getWidth(),100);
    }
    if (args.length >= 3){
      int decrease = Integer.parseInt(args[2]);
      Image imgdecrease = img.decreaseNbGrayLevels(decrease);
      imgDisplay.display(imgdecrease,"decrease picture",100+img.getWidth()*2,100);
    }
  }
}
