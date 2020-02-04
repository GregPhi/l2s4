import static org.junit.Assert.*;
import org.junit.Test;

import goosegame.cell.*;
import goosegame.board.*;
import goosegame.*;

/**
 * Class CellTest
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class CellTest{

  @Test
  public void testNormalCell(){
    NormalCell cell = new NormalCell(1);
    Player player = new Player("playerTest",cell);
    cell.welcomePlayer(player);
    assertTrue(cell.getIndex() == 1);
    assertTrue(cell.isBusy());
    assertTrue(cell.handleMove(12) == 1);
    assertTrue(cell.canBeLeft());
  }

  @Test
  public void testWaitCell(){
    WaitCell cell2 = new WaitCell(2,2);
    Player player = new Player("playerTest",cell2);
    cell2.welcomePlayer(player);
    assertFalse(cell2.canBeLeft());
    assertFalse(cell2.canBeLeft());
    assertTrue(cell2.canBeLeft());
  }
  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(CellTest.class);
  }
}
