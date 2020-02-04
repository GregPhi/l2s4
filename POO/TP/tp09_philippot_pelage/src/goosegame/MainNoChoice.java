package goosegame;

import java.util.*;
import goosegame.*;
import goosegame.cell.*;
import goosegame.board.*;

/**
 * Class Main
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class MainNoChoice{

  /**
   * Main of goosegame
   *
   * @param args (type-String[])
   */
  public static void main(String[] args){

    Board board = new ClassicBoard();
    Game goosegame = new Game(board);
    goosegame.addPlayer(new Player("player 1"));
    goosegame.addPlayer(new Player("player 2"));
    goosegame.addPlayer(new Player("player 3"));
    goosegame.addPlayer(new Player("player 4"));
    goosegame.play();
  }
}
