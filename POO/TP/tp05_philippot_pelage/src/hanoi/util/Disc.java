package hanoi.util;

/**
 * Class Disc
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 15 février 2017
 */

public class Disc{
  //Attributs
  /* Size of Disc */
  private int size;

  //Constructor
  /**
   * Create a Disc with a size
   *
   * @param size : (type-int)
   */
  public Disc(int size){
    this.size = size;
  }

  //Methods
  /**
   * Get the size of Disc
   *
   * @return : (type-int)
   */
  public int getSize(){
    return this.size;
  }

  /**
   * Return : the size of this Disc is : this.size
   *
   * @return : (type-String)
   */
  public String toString(){
    return "the size of this Disc is : " +this.size;
  }

  /**
   * Check if <code>o</code> size is equals to o.size
   *
   * @return : (type-boolean) <code>true</code> iff <code>o</code> is a Disc with the same size as this word.
   */
   public boolean equals(Object o) {
     if (o instanceof Disc) {
         Disc theOther = (Disc) o;
         return this.size == theOther.size;
     } else {
         return false;
     }
   }
}
