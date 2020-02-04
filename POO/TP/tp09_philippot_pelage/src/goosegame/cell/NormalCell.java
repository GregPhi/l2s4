package goosegame.cell;

import goosegame.Cell;
import goosegame.Player;

/**
 * Class NormalCell extends Cell
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class NormalCell implements Cell{
  //ATTRIBUTS
  /* index */
  protected int idx;
  /* busy ? */
  protected boolean busy;
  /* Player int cell */
  protected Player player;

  //CONSTRUCTOR
  /**
   * Create a NormalCell
   *
   * @param idx (type-int)
   */
  public NormalCell(int idx){
    this.idx = idx;
    this.busy = false;
  }

  //@Overide
  public boolean canBeLeft(){
    return true;
  }
  //@Overide
  public int getIndex(){
    return this.idx;
  }
  //@Overide
  public int handleMove(int diceThrow){
    return this.idx;
  }
  //@Overide
  public boolean isBusy(){
    return this.busy;
  }
  //@Overide
  public void welcomePlayer(Player player){
    this.player = player;
    this.busy = true;
  }
  //@Overide
  public Player getPlayer(){
    return this.player;
  }

  public String toString(){
    return "normalCell";
  }
  public void byePlayer(){
    this.player = null;
    this.busy = false;
  }

  //@Overide
  public boolean equals(Object o){
    if(o instanceof Cell){
      Cell c = (Cell)o;
      return this.toString() == c.toString();
    }
    return false;
  }
}
