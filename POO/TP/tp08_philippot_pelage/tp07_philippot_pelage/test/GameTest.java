import org.junit.*;
import static org.junit.Assert.*;
import game.*;
import game.strategy.*;

public class GameTest{

  @Test
  public void Testwinner(){
    Strategy s1 = new RockStrategy();
    Strategy s2 = new ScissorStrategy();
    Player p1 = new Player(s1);
    Player p2 = new Player(s2);
    Game g = new Game(p1,p2,1);
    g.playOneRound();
    assertTrue(g.getWinner() == p1.getName());
  }

  @Test
  public void Testequals(){
    Strategy s1 = new RandomStrategy();
    Strategy s2 = new RandomStrategy();
    Player p1 = new Player(s1);
    Player p2 = new Player(s2);
    Game g = new Game(p1, p2, 1);
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(GameTest.class);
  }
}
