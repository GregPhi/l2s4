package rental;

import java.util.*;

/**
 * Class RentalAgency
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

/** a rental vehicle agency, client can rent one vehicle at a time */
public class RentalAgency {
    // vehicles of this agency
    protected List<Vehicle> theVehicles;

    // maps client and rented vehicle (at most one vehicle by client)
    protected Map<Client,Vehicle> rentedVehicles;

    public RentalAgency() {
    	this.theVehicles = new ArrayList<Vehicle>();
      this.rentedVehicles = new HashMap<Client, Vehicle>();
    }

    /** adds a vehicle to this agency
    * @param v the added vehicle
    */
    public void addVehicle(Vehicle v) {
    	this.theVehicles.add(v);
    }

    /** provides the list of the vehicles that satisfy the criterion c
    * @param c the selection criterion
    * @return  the list of the vehicles that satisfy the criterion c
    */
    public List<Vehicle> select(Criterion c) {
    	List<Vehicle> res = new ArrayList<Vehicle>();
      if(!(this.theVehicles == null)){
        for(Vehicle v : this.theVehicles){
          if(c.isSatisfiedBy(v)){
            res.add(v);
          }
        }
      }
      return res;
    }

    /** displays the vehicles that satisfy the criterion c
    * @param c the selection criterion
    */
    public void displaySelection(Criterion c) {
    	List<Vehicle> listofVehicle = this.select(c);
      for(Vehicle v : listofVehicle){
        System.out.println(v.toString());
      }
    }

    /** client rents a vehicle
    * @param client the renter
    * @param v the rented vehicle
    * @return the daily rental price
    * @exception UnknowVehicleException   if v is not a vehicle of this agency
    * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v) throws UnknowVehicleException, IllegalStateException {
    	if (this.theVehicles == null){
        throw new UnknowVehicleException();
      }
      if (this.hasRentedAVehicle(client)){
        throw new IllegalStateException("This client has already a vehicle");
      }
      if (this.theVehicles.contains(v)){
        if (this.isRented(v)){
          throw new IllegalStateException("Vehicle already rent");
        }else{
          this.rentedVehicles.put(client, v);
        }
      }else{
        throw new UnknowVehicleException();
      }
      return v.getDailyPrice();
    }

    /** returns <em>true</em> iff client c is renting a vehicle
    * @param client : (type-Client)
    * @return <em>true</em> iff client c is renting a vehicle
    */
    public boolean hasRentedAVehicle(Client client){
    	for (Client c : this.rentedVehicles.keySet()){
        if(c.equals(client)){
          return true;
        }
      }
      return false;
    }

    /** returns <em>true</em> iff vehicle v is rented
    * @param v : (type-Vehicle)
    * @return <em>true</em> iff vehicle v is rented
    */
    public boolean isRented(Vehicle v){
    	if (this.rentedVehicles.containsValue(v)){
        return true;
      }
      return false;
    }

    /** the client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle.
    * @param client : (type-Client) he client who returns a vehicle
    */
    public void returnVehicle(Client client){
    	if (this.hasRentedAVehicle(client)){
        this.rentedVehicles.remove(client, this.rentedVehicles.get(client));
      }
    }
    /** provides the collection of rented vehicles for this agency
    * @return collection of currently rented vehicles
    */
    public Collection<Vehicle> allRentedVehicles(){
    	return this.rentedVehicles.values();
    }

}
