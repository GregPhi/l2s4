import org.junit.*;
import static org.junit.Assert.*;
import game.*;
import game.strategy.*;

public class PlayerTest{

  @Test
  public void Testequals(){
    Strategy s1 = new RandomStrategy();
    Strategy s2 = new ScissorStrategy();
    Player p1 = new Player(s1);
    Player p2 = new Player(s2);
    assertFalse(p1.equals(p2));
  }

  @Test
  public void Testscore(){
    Strategy s1 = new RandomStrategy();
    Strategy s2 = new RandomStrategy();
    Player p1 = new Player(s1);
    Player p2 = new Player(s2);
    assertTrue(p1.getScore() == p2.getScore());
    p2.addPoints(2);
    assertTrue(p1.getScore() != p2.getScore());
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
  }
}
