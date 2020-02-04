import org.junit.*;
import static org.junit.Assert.*;
import game.*;
import game.strategy.*;

public class GameTest{

  @Test
  public void Testwinner(){
    Strategy s1 = new RockStrat();
    Strategy s2 = new ScissorsStrat();
    Player p1 = new Player(s1);
    Player p2 = new Player(s2);
    Game g = new Game(p1,p2,1);
    g.playOneRound();
    assertTrue(g.getWinner(),this.p1.getName());
  }

  @Test
  public void Testequals(){
    
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(GameTest.class);
  }
}
