package hanoi.util;

/**
 * Exception TowerIsFullException :
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 15 février 2017
 */

public class TowerIsFullException extends Exception{
  //Constructor
  /**
   * TowerIsFullException
   *
   * @param msg : (type-String)
   */
  public TowerIsFullException(String msg){
    super(msg);
  }
}
