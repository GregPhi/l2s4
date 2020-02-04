package goosegame;

/**
 * Abstract class Board
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public abstract class Board{
  //ATTRIBUTS
  /* Number of Cells */
  protected int nbOfCells;
  /* Board */
  protected Cell[] theCells;

  //CONSTRUCTOR
  /**
   * Create a board
   *
   * @param nbOfCells (type-int)
   */
  public Board(int nbOfCells){
    this.nbOfCells = nbOfCells;
    this.theCells = new Cell[nbOfCells];
    this.initBoard();
  }

  /**
   * Initialize board
   */
  protected void initBoard(){}

  //METHODS
  /**
   * Get number of Cell in this board
   *
   * @return (type-int)
   */
  public int getNbOfCells(){
    return this.nbOfCells;
  }

  /**
   * Get cell
   *
   * @param number (type-int)
   * @return (type-Cell)
   */
  public Cell getCell(int number){
    return this.theCells[number];
  }

  /**
   * Check if <code>o</code> is equals to this board
   *
   * @param o (type-Object)
   * @return (type-boolean)
   */
  //@Overide
  public boolean equals(Object o){
    if(o instanceof Board){
      Board b = (Board)o;
      if(this.nbOfCells == b.getNbOfCells()){
        for(int i = 0; i < this.nbOfCells; i++){
          if(!(this.theCells[i].equals(b.getCell(i)))){
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  /**
   * String of the number of cells
   *
   * @return (type-String)
   */
  public String toString(){
    return this.nbOfCells + "";
  }
}
