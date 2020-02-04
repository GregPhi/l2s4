package rental;

import java.util.*;

/**
 * Class SuspiciousRentalAgency extends RentalAgency
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class SuspiciousRentalAgency extends RentalAgency{

  /**
   * Get the daily price of the vehicle <code>v</code>, with a 
   *
   * @param c : (type-Vehicle)
   * @param v : (type-Vehicle)
   * @return : (type-float)
   * @exception UnknowVehicleException : Unknow vehicle
   * @exception IllegalStateException : Client have already a vehicle or Vehicle has already rent
   */
  public float rentVehicle(Client c, Vehicle v) throws UnknowVehicleException, IllegalStateException{
    if (this.theVehicles == null){
      throw new UnknowVehicleException();
    }
    if (this.hasRentedAVehicle(c)){
      throw new IllegalStateException("Client have already a vehicle");
    }
    if( this.theVehicles.contains(v)){
      if (this.isRented(v)){
        throw new IllegalStateException("Vehicle has already rent");
      }else{
        this.rentedVehicles.put(c,v);
      }
    }else{
      throw new UnknowVehicleException();
    }
    if(c.getAge() <= 25){
      return ((float)v.getDailyPrice()*1.1f);
    }
    return v.getDailyPrice();
  }

}
