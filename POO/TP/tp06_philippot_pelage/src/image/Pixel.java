package image;

import image.color.GrayColor;
import java.lang.Math;

/**
 * Class Pixel :
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 27 fevrier 2017
 */

public class Pixel{
  //Attributs
  /* */
  private GrayColor color;

  //Constructor
  /**
   * Create a pixel
   *
   * @param color : (type-GrayColor)
   */
  public Pixel(GrayColor color){
    this.color = color;
  }

  /**
   * Get color
   *
   * @return : (type-GrayColor)
   */
  public GrayColor getColor(){
    return this.color;
  }

  /**
   * Set color
   *
   * @param color: (type-GrayColor)
   */
  public void setColor(GrayColor color){
    this.color = color;
  }

  /**
   * Color difference with a other pixel
   *
   * @param p : (type-Pixel)
   * @return (type-int)
   */
  public int colorDifference(Pixel p){
    return Math.abs(this.getColor().getGrayLevel()-p.getColor().getGrayLevel());
  }

  /**
   * Check if color is equals
   *
   * @param o : (type-Object)
   * @return : (type-boolean)
   */
  public boolean equals(Object o){
    if (!(o instanceof Pixel)){
      return false;
    }
    if (this.color == ((Pixel)o).getColor()){
      return true;
    }
    return false;
  }
}
