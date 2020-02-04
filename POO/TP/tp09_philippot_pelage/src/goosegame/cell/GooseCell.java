package goosegame.cell;

/**
 * Class GooseCell extends Cell
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class GooseCell extends NormalCell{
  /**
   * Create a GooseCell
   *
   * @param idx (type-int)
   */
  public GooseCell(int idx){
    super(idx);
  }

  public int handleMove(int diceThrow){
    return this.idx+diceThrow;
  }

  //@Overide
  public String toString(){
    return "gooseCell";
  }
}
