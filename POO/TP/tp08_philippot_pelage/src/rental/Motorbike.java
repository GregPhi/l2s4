package rental;

/**
 * Class Motorbike extends Vehicle
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.0
 */

public class Motorbike extends Vehicle{
  //ATTRIBUTS
  /* cylindre of motorbike */
  protected int cylindre;

  //CONSTRUCTOR
  /**
   * Create a motorbike
   *
   * @param brand : (type-String)
   * @param model : (type-String)
   * @param productionYear : (type-int)
   * @param dailyRentalPrice : (type-float)
   * @param cylindre : (type-int)
   */
  public Motorbike(String brand, String model, int productionYear, float dailyRentalPrice, int cylindre){
    super(brand, model, productionYear, dailyRentalPrice);
    this.cylindre = cylindre;
  }

  //METHODS
  /**
   * Get the cylindre
   *
   * @return : (type-int)
   */
  public int getCylindre(){
    return this.cylindre;
  }

  /**
   * Check if this motorbike is equals to <code>o</code>
   * Return true if <code>o</code> is equals to ths motorbike, else false
   *
   * @param o : (type-Object)
   * @return : (type-boolean)
   */
  public boolean equals(Object o){
    if(!(o instanceof Motorbike)){
      return false;
    }
    Motorbike m = (Motorbike)o;
    return this.brand == m.brand
      && this.model == m.model
      && this.productionYear == m.productionYear
      && this.dailyRentalPrice == m.dailyRentalPrice
      && this.cylindre == m.cylindre;
  }

  /**
   * Description of motorbike
   *
   * @return : (type-String)
   */
  public String toString(){
    String b = "Brand : " +this.brand;
    String m = "Model : " +this.model;
    String p = "Production Year : " +this.productionYear;
    String d = "Daily Rental Price : " +this.dailyRentalPrice;
    String c = "Cylindre : " +this.cylindre;
    return b+" "+m+" "+p+" "+d+" "+c;
  }
}
