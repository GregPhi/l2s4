package goosegame.board;

import goosegame.Board;
import goosegame.cell.*;
import java.util.Random;

/**
 * Class RandomBoard extends Board
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class RandomBoard extends Board{
  //CONSTRUCTOR
  /**
   * Create semi-random board
   *
   * @param nbOfCells (type-int)
   */
  public RandomBoard(int nbOfCells){
    super(nbOfCells);
    initBoard();
  }

  //INIT BOARD
  protected void initBoard(){
    int rdint;
    int i;
    int nb;
    int target;
    int leftcell = this.nbOfCells/2;
    for(i = 0; i < this.nbOfCells; i++){
      this.theCells[i] = new NormalCell(i);
    }
    rdint = new Random().nextInt(leftcell/3);
    leftcell-=rdint;
    for(i = 0; i < rdint; i++){
      nb = new Random().nextInt(nbOfCells);
      target = new Random().nextInt(nbOfCells);
      this.theCells[nb] = new TpCell(nb,target);
    }
    rdint = new Random().nextInt(leftcell/3);
    leftcell-=rdint;
    for(i = 0; i < rdint; i++){
      nb = new Random().nextInt(nbOfCells);
      target = (new Random().nextInt(5))+1;
      this.theCells[nb] = new WaitCell(nb, target);
    }
    rdint = new Random().nextInt(leftcell/3);
    leftcell-=rdint;
    for(i = 0; i < rdint; i++){
      nb = new Random().nextInt(nbOfCells);
      this.theCells[nb] = new TrapCell(nb);
    }
  }
}
