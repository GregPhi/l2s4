package rental;

import java.util.*;

/** main to test for question  Q2 */
public class MainQ2 {

  /**
   * Question 2
   *
   * @param args : (type-String)
   * @exception UnknowVehicleException :  "Unknow vehicle"
   */
  public static void main(String[] args) throws UnknowVehicleException{
  	RentalAgency agency = new RentalAgency();
  	Vehicle v = new Vehicle("b","m",2016,100);
  	agency.addVehicle(v);
  	Client c1 = new Client("Tim Oleon", 40);
  	float price = agency.rentVehicle(c1,v);
  	Client c2 = new Client("Tim Oleon", 40);
  	boolean b = agency.hasRentedAVehicle(c2);
  	System.out.println("computed value for 'b'  : "+b+"( /!\\ must be true /!\\)");
  }
}
