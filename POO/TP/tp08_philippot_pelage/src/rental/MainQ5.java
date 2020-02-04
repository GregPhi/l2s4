package rental;

/**
 * Class MainQ5
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class MainQ5{
  /**
   * Question 5
   *
   * @param args : (type-String)
   * @exception UnknowVehicleException :  "Unknow vehicle"
   */
  public static void main(String[] args) throws UnknowVehicleException{
    RentalAgency agency = new RentalAgency();
    Vehicle v = new Vehicle("Do","Re",2016,100);
    Car c = new Car("Mi","La",2015,150,4);
    Motorbike m = new Motorbike("Sol","La",2010,95,10);
    agency.addVehicle(v);
    agency.addVehicle(c);
    agency.addVehicle(m);
    Client c1 = new Client("Titi",15);
    Client c2 = new Client("Toto",15);
    Client c3 = new Client("Tata",15);
    float price1 = agency.rentVehicle(c1,v);
    float price2 = agency.rentVehicle(c2,c);
    float price3 = agency.rentVehicle(c3,m);
    System.out.println(c1.getName()+" pay "+price1+" for a vehicle.");
    System.out.println(c2.getName()+" pay "+price2+" for a car.");
    System.out.println(c3.getName()+" pay "+price3+" for a motorbike.");
  }
}
