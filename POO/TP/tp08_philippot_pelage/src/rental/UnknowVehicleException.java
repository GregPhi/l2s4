package rental;

/**
 * Class UnknowVehicleException extends Exception
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class UnknowVehicleException extends Exception{
  //CONSTRUCTOR
  /**
   * UnknowVehicleException
   */
  public UnknowVehicleException(){
    super("Unknown vehicle");
  }
}
