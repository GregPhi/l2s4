import static org.junit.Assert.*;
import org.junit.Test;

import goosegame.cell.*;
import goosegame.board.*;
import goosegame.*;

/**
 * Class PlayerTest
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class PlayerTest{

  @Test
  public void testPlayer(){
    Player player = new Player("playerTest");
    assertNotNull("player create ?", player);
  }

  @Test
  public void testGetSetCell(){
    NormalCell cell = new NormalCell(1);
    Player player = new Player("playerTest");
    assertNull("no cell set", player.getCell());
    player.setCell(cell);
    assertNotNull("cell set",player.getCell());
    assertSame("same cell ?",cell,player.getCell());
    assertNotSame("not same cell ?",new NormalCell(2),player.getCell());
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
  }
}
