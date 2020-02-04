import static org.junit.Assert.*;
import org.junit.Test;

import goosegame.cell.*;
import goosegame.board.*;
import goosegame.*;

/**
 * Class BoardTest
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class BoardTest{

  @Test
  public void testgetCell(){
    Board board = new ClassicBoard();
    assertNotNull("cell exist ?",board.getCell(5));
  }

  @Test
  public void testinitBoard(){
    Board board = new ClassicBoard();
    for(int i = 0; i < 63; i++){
      assertNotNull("cell is initialized ?",board.getCell(i));
    }
  }

  @Test
  public void testEquals(){
    Board board = new ClassicBoard();
    Board board2 = new ClassicBoard();
    RandomBoard board3 = new RandomBoard(63);
    assertTrue(board.equals(board2));
    assertFalse(board.equals(board3));
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(BoardTest.class);
  }
}
