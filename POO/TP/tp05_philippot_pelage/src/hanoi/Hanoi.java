package hanoi;

import hanoi.util.*;
import hanoi.io.HanoiInput;
import java.io.PrintStream;

/**
 * Class Hanoi
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 21 février 2017
 */

public class Hanoi{
  //Attributs
  /* Tower of hanoi game */
  private Tower[] tower;

  /* Capacity of tower */
  private int capacity;

  //Constructor
  /**
   * Create hanoi game
   *
   * @param capa : (type-int)
   */
  public Hanoi(int capa){
    this.capacity = capa;
    this.tower = new Tower[3];
    for (int i = 0; i < 3; i++){
      this.tower[i] = new Tower(capa);
    }
    for (int i = capa; i > 0; i--){
      try{
        Disc d = new Disc(i);
        this.tower[0].push(d);
      }catch (Exception e){
        //Handle exception
      }
    }
  }

  //Methods
  /**
   * Verifies that the player can move the disc from source to destination
   *
   * @param source : (type-int)
   * @param destination : (type-int)
   * @return : (type-boolean)
   * @exception TowerIsEmptyException : "This tower is empty."
   */
  public boolean isAllowed(int source, int destination) throws TowerIsEmptyException{
    Tower towerSource = this.tower[source];
    Tower towerDestination = this.tower[destination];
    if (!towerSource.isEmpty() && !towerDestination.isEmpty()){
      return this.tower[source].top().getSize() < this.tower[destination].top().getSize();
    }else{
      return true;
    }
  }

  /**
   * Display the state of the hanoi board
   Display vertical
  public void display(){
	for (int j = 0; j < 3; j++){
		System.out.println("Tower : " +j);
		for (int img = this.capacity - 1; img >= 0; img--){
        System.out.println(this.tower[j].pict(img));
      }
      System.out.println("");
    }
    System.out.println("");
  }*/

  /**
   * Display the state of the hanoi board
   */
  public void display(){
    for(int img = this.capacity -1; img >= 0; img--){
      String esp = new String(new char[this.capacity]).replace("\0"," ");
      System.out.println(this.tower[0].pict(img)+esp+this.tower[1].pict(img)+esp+this.tower[2].pict(img));
    }
    System.out.println("");
  }

  /**
   * Moves one disc from a tower to another
   *
   * @param source : (type-int)
   * @param destination : (type-int)
   */
  public void moveOneDisc(int source, int destination){
    Tower towerSource = this.tower[source];
    Tower towerDestination = this.tower[destination];
    try{
      Disc discToMove = towerSource.pop();
      towerDestination.push(discToMove);
    }catch(Exception e){

    }
    this.display();
  }

  /**
   * Check if the game is solved
   *
   * @return : (type-boolean) <code>true</code> if the right tower is full, <code>false</code> otherwise
   */
  public boolean isSolved(){
    return this.tower[2].isFull();
  }

  /**
   * Solve the hanoi game
   *
   * @param nb : (type-int)
   * @param source : (type-int)
   * @param destination : (type-int)
   * @param auxilary : (type-int)
   */
  public void solve(int nb, int source, int destination, int auxilary){
    if (nb == 1){
      this.moveOneDisc(source, destination);
    }else{
      this.solve(nb-1, source, auxilary, destination);
      this.moveOneDisc(source, destination);
      this.solve(nb-1, auxilary, destination, source);
    }
  }
}
