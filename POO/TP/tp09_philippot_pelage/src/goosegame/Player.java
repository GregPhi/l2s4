package goosegame;
/** A player in the "jeu de l'oie" game */
public class Player {
    /** current cell of the player */
    protected Cell cell;
    /** name of the player*/
    protected String name;
    /** order/
    protected int order;*/

    /**
     * @param name the name of this player
     * @param cell the starting cell of this player
    */
    public Player (String name, Cell cell){
        this.name = name;
        this.cell = cell;
        //this.order = 0;
    }
    /**  A player with no current cell (== null)
     * @param name the name of this player
     *
    */
    public Player (String name){
        this.name = name;
        this.cell = null;
    }
    /** */
    public String toString() { return name; }
    /** get order of player
    public int getOrder(){
      return this.order;
    }*/
    /** returns the current cell of the player
      *  @return the current cell of the player
      */
    public Cell getCell() {
       return this.cell ;
    }
    /** changes the cell of the player
     * @param newCell the new cell
    */
    public void setCell(Cell newCell) {
       this.cell = newCell;
    }
    /** result of a 1d6 throw
     * @return random result of a 1d6 throw
    */
    private int oneDieThrow() {
       return ((int) (Math.random()*10000) % 6)+ 1;
    }
    /** result of a 2d6 throw
      * @return random result of a 2d6 throw
    */
    public int twoDiceThrow() {
        int result = oneDieThrow() + oneDieThrow();
        return result;
    }

    /**
      * Check if this player is equals to <code>o</code>
      *
      * @param o (type-Object)
      * @return (type-boolean)
      */
    public boolean equals(Object o){
      if(o instanceof Player){
        Player p = (Player)o;
        return this.name == o.toString();
      }
      return false;
    }
}// Player
