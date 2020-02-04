package hanoi.util;

/**
 * Exception TowerIsEmptyException :
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 15 février 2017
 */

public class TowerIsEmptyException extends Exception{
  //Constructor
  /**
   * TowerIsEmptyException
   *
   * @param msg : (type-String)
   */
  public TowerIsEmptyException(String msg){
    super(msg);
  }
}
