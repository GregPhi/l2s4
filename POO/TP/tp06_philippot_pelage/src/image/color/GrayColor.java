package image.color;

/**
 * Class GrayColor :
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 27 fevrier 2017
 */

public class GrayColor{

  //Attributs
  /* grayLevel */
  private int grayLevel;

  /* WHITE */
  public static final GrayColor WHITE = new GrayColor(255);

  /* BLACK */
  public static final GrayColor BLACK = new GrayColor(0);

  //Constructor
  /**
   * Create GrayColor
   *
   * @param level : (type-int)
   */
  public GrayColor(int level){
    if (level >= 0 && level <= 255){
      this.grayLevel = level;
    }
    else{
      this.grayLevel = 255;
    }
  }

  //Methods
  /**
   * Get grayLevel
   *
   * @return : (type-int)
   */
  public int getGrayLevel(){
    return this.grayLevel;
  }

  /**
   *
   *
   * @param o : (type-Object)
   * @return :(type-boolean)
   */
  public boolean equals(Object o){
    if (!(o instanceof GrayColor)){
      return false;
    }
    if (this.grayLevel == ((GrayColor)o).getGrayLevel()){
      return true;
    }
    return false;
  }
}
