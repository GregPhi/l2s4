package rental;

/**
 * Class Car extends Vehicle
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class Car extends Vehicle{

  // ATTRIBUTS
  /* Capacity of passagers */
  protected int capacityOfPassagers;

  // CONSTRUCTOR
  /**
   * Create a car
   *
   * @param brand : (type-String)
   * @param model : (type-String)
   * @param productionYear : (type-int)
   * @param dailyRentalPrice : (type-float)
   * @param capacityOfPassagers : (type-int)
   */
  public Car(String brand, String model, int productionYear, float dailyRentalPrice, int capacityOfPassagers){
    super(brand, model, productionYear, dailyRentalPrice);
    this.capacityOfPassagers = capacityOfPassagers;
  }

  // METHODS
  /**
   * Get the capacity of passagers
   *
   * @return : (type-int)
   */
  public int getCapacityOfPassengers(){
    return this.capacityOfPassagers;
  }

  /**
   * Check if this car is equals to <code>o</code>
   * True if o is equals to this car, else false
   *
   * @param o : (type-Object)
   * @return : (type-boolean)
   */
  public boolean equals(Object o){
    if(!(o instanceof Car)){
      return false;
    }
    Car c = (Car)o;
    return this.brand == c.brand
      && this.model == c.model
      && this.productionYear == c.productionYear
      && this.dailyRentalPrice == c.dailyRentalPrice
      && this.capacityOfPassagers == c.capacityOfPassagers;
  }

  /**
   * Return the description of this car
   *
   * @return : (type-String)
   */
  public String toString(){
    String b = "Brand : " +this.brand;
    String m = "Model : " +this.model;
    String p = "Production Year : " +this.productionYear;
    String d = "Daily Rental Price : " +this.dailyRentalPrice;
    String c = "Capacity Of Passagers : " +this.capacityOfPassagers;
    return b+" "+m+" "+p+" "+d+" "+c;
  }

}
