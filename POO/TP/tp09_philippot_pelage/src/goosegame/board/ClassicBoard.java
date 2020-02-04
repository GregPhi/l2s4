package goosegame.board;

import goosegame.cell.*;
import goosegame.Board;

/**
 * Class ClassicBoard
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class ClassicBoard extends Board{
  //CONSTRUCTOR
  /**
   * Create a classical Board
   */
  public ClassicBoard(){
    super(63);
    initBoard();
  }

  //INIT BOARD
  protected void initBoard(){
    this.nbOfCells = 63;
    for(int i = 0; i < this.nbOfCells; i++){
      this.theCells[i] = new NormalCell(i);
    }
    //GooseCell
    this.theCells[8] = new GooseCell(8);
    this.theCells[17] = new GooseCell(17);
    this.theCells[26] = new GooseCell(26);
    this.theCells[35] = new GooseCell(35);
    this.theCells[44] = new GooseCell(44);
    this.theCells[53] = new GooseCell(53);

    //TrapCell
    this.theCells[30] = new TrapCell(30);
    this.theCells[51] = new TrapCell(51);

    //WaitCell
    this.theCells[18] = new WaitCell(18,2);

    //TpCell
    this.theCells[5] = new TpCell(5,11);
    this.theCells[41] = new TpCell(41,29);
    this.theCells[57] = new TpCell(57,0);
  }
}
