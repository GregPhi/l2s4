package game;

/**
 * Enum Shape
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 4 mars 2017
 */

public enum Shape{
  PAPER,SCISSORS,ROCK;

  /**
   * Compare if this destroy s, or destroyed by, or is s
   *
   * @param s : (type-Shape)
   * @return : (type-int)
   */
  public int compare(Shape s){
    switch(this){
      case PAPER:
      switch(s){
        case SCISSORS : return -1;
        case ROCK : return 1;
        default : return 0;
      }
      case SCISSORS:
      switch(s){
        default : return 0;
        case ROCK : return -1;
        case PAPER : return 1;
      }
      case ROCK:
      switch(s){
        case SCISSORS : return 1;
        default : return 0;
        case PAPER : return -1;
      }
      default : return 0;
    }
  }
}
