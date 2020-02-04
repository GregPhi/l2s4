package hanoi.util;

import hanoi.*;
import hanoi.util.*;
/**
 * Class Tower
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 15 février 2017
 */

public class Tower{
  //Attributs
  /* List of Disc in Tower */
  private Disc[] theDisc;

  /* Capacity of Tower */
  private int capacity;

  /* Nb Discs in Tower */
  private int nbDisc;

  //Constructor
  /**
   * Create a Tower
   *
   * @param c : (type-int)
   */
  public Tower(int c){
    this.nbDisc = 0;
    this.capacity = c;
    this.theDisc = new Disc[c];
  }

  //Methods
  /**
   * Get the number of discs in the tower
   *
   * @return : (type-int)
   */
  public int getNbDisc(){
    return this.nbDisc;
  }

  /**
   * Get the capacity of the tower
   *
   * @return : (type-int)
   */
  public int getCapacity(){
    return this.capacity;
  }

  /**
   * Check if the tower is full
   *
   * @return : (type-boolean) return <code>true</code> iff Tower is full
   */
  public boolean isFull(){
    return this.nbDisc == this.capacity;
  }

  /**
   * Check if the tower is empty
   *
   * @return : (type-boolean) return <code>true</code> iff Tower is empty
   */
  public boolean isEmpty(){
    return this.nbDisc == 0;
  }

  /**
   * Get the top disc of the tower
   *
   * @return : (type-Disc) disc on top of the tower
   * @exception TowerIsEmptyException : if tower is empty
   */
  public Disc top() throws TowerIsEmptyException{
    if (!this.isEmpty()){
      return this.theDisc[this.nbDisc-1];
    }else{
      throw new TowerIsEmptyException("This tower is empty.");
    }
  }

  /**
   * Push a disc in this tower
   *
   * @param d : (type-Disc) disc to push on the top of tower
   * @exception TowerIsFullException : if tower is full
   */
  public void push(Disc d) throws TowerIsFullException{
    if (!this.isFull()){
      this.theDisc[this.nbDisc] = d;
      this.nbDisc++;
    }else{
      throw new TowerIsFullException("This tower is full.");
    }
  }

  /**
   * Pop the top disc of the tower
   *
   * @return : (type-Disc)
   * @exception TowerIsEmptyException : if tower is empty
   */
  public Disc pop() throws TowerIsEmptyException{
    if (!this.isEmpty()){
      this.nbDisc--;
      return this.theDisc[nbDisc];
    }else{
      throw new TowerIsEmptyException("This tower is empty");
    }
  }

  /**
   * Give string representation of tower
   *
   * @param img : (type-int)
   * @return : (type-String)
   */
  public String pict(int img){
    String res = "";
    if (img >= this.nbDisc){
      int i;
      for (i=0; i < this.capacity; i++){
        res += " ";
      }
      res += "|";
      for (i = i; i> 0; i--){
        res+= " ";
      }
    }else{
      int dSize = this.theDisc[img].getSize();
      int capa = this.capacity;
      int i;
      for (i = 0; i < (capa - dSize); i++){
        res += " ";
      }
      for (i = i; i < capa; i++){
        res += "_";
      }
      res += "|";
      for (i = i; i> (capa - dSize); i--){
        res += "_";
      }
      for (i=i; i>0; i--){
        res+= " ";
      }
    }
    return res;
  }
}
