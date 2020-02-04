package goosegame.cell;

/**
 * Class TpCell extends NormalCell
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class TpCell extends NormalCell{
  //ATTRIBUTS
  /* target */
  protected int target;

  //CONSTRUCTOR
  /**
   * Create tp cell
   *
   * @param idx (type-int)
   * @param target (type-int)
   */
  public TpCell(int idx, int target){
    super(idx);
    this.target = target;
  }

  public int handleMove(int diceThrow){
    return this.target;
  }

  //@Overide
  public String toString(){
    return "tpCell";
  }
}
