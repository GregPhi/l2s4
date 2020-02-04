package goosegame.cell;

/**
 * Class TrapCell extends NormalCell
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class TrapCell extends NormalCell{
  /**
   * Create trap cell
   *
   * @param idx (type-int)
   */
  public TrapCell(int idx){
    super(idx);
  }

  public boolean canBeLeft(){
    return false;
  }

  //@Overide
  public String toString(){
    return "trapCell";
  }
}
