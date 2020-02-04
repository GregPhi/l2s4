package rental;

/**
 * Class MainQ7
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class MainQ7{
  /**
   * Question 7
   *
   * @param args : (type-String)
   * @exception UnknowVehicleException :  "Unknow vehicle"
   */
  public static void main(String[] args) throws UnknowVehicleException{
    SuspiciousRentalAgency agency = new SuspiciousRentalAgency();
    Vehicle v = new Vehicle("Do","Re",2016,100);
    agency.addVehicle(v);
    Client c1 = new Client("Titi",15);
    Client c2 = new Client("Toto",30);
    float price = agency.rentVehicle(c1,v);
    System.out.println(c1.getName()+" pay "+price+" for a vehicle.");
    agency.returnVehicle(c1);
    price = agency.rentVehicle(c2,v);
    System.out.println(c2.getName()+" pay "+price+" for a vehicle.");
  }
}
