package goosegame;

/**
 * Interface Cell
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public interface Cell{
  //METHODS
  /**
   * Can be left ?
   *
   * @return (type-boolean)
   */
  public boolean canBeLeft();

  /**
   * Get Index of cell
   *
   * @return (type-int)
   */
  public int getIndex();

  /**
   * Handle Move
   *
   * @param diceThrow (type-int)
   * @return (type-int)
   */
  public int handleMove(int diceThrow);

  /**
   * Is Busy ?
   *
   * @return (type-boolean)
   */
  public boolean isBusy();

  /**
   * Welcome Player
   *
   * @param player (type-Player)
   */
  public void welcomePlayer(Player player);

  /**
   * Get player
   *
   * @return (type-Player)
   */
  public Player getPlayer();

  /**
   * Bye Player
   */
  public void byePlayer();
}
