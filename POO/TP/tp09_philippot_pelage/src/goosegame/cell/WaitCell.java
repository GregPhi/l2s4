package goosegame.cell;

/**
 * Class WaitCell extends NormalCell
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class WaitCell extends NormalCell{
  //ATTRIBUTS
  /* Max turn to wait */
  protected int maxturn;
  /* Actual turn to wait */
  protected int actualturn;

  //CONSTRUCTOR
  /**
   * Create wait cell
   *
   * @param idx (type-int)
   * @param maxturn (type-int)
   */
  public WaitCell(int idx, int maxturn){
    super(idx);
    this.maxturn = maxturn;
    this.actualturn = maxturn;
  }

  public boolean canBeLeft(){
    if(this.busy){
      if(actualturn <= 0){
        actualturn = maxturn;
        return true;
      }
      actualturn = actualturn - 1;
      return false;
    }
    return false;
  }

  //@Overide
  public String toString(){
    return "waitCell";
  }
}
