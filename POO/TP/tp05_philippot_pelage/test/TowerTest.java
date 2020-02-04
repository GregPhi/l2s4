import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.*;

/**
 * Class TowerTest :
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 24 fevrier 2017
 */

public class TowerTest{

  @Test
  public void testCapcity(){
    Tower t = new Tower(5);
    assertEquals(t.getCapacity(),5);
  }

  @Test
  public void testNbDisc() throws TowerIsEmptyException, TowerIsFullException{
    Tower t = new Tower(3);
    Disc d1 = new Disc(3);
    Disc d2 = new Disc(2);
    t.push(d1);
    t.push(d2);
    assertEquals(t.getNbDisc(),2);
  }

  @Test
  public void testFullTower() throws TowerIsEmptyException, TowerIsFullException{
    Tower t = new Tower(3);
    assertFalse(t.isFull());
    Disc d1 = new Disc(3);
    Disc d2 = new Disc(2);
    Disc d3 = new Disc(1);
    t.push(d1);
    t.push(d2);
    t.push(d3);
    assertTrue(t.isFull());
  }

  @Test
  public void testTowerIsEmpty() throws TowerIsEmptyException, TowerIsFullException{
    Tower t = new Tower(3);
    assertTrue(t.isEmpty());
    Disc d1 = new Disc(3);
    t.push(d1);
    assertFalse(t.isEmpty());
  }

  @Test
  public void testTopOfTower() throws TowerIsEmptyException, TowerIsFullException{
    Tower t = new Tower(3);
    Disc d1 = new Disc(3);
    t.push(d1);
    Disc d2 = t.pop();
    assertEquals(d2, d1);
    Disc d3 = new Disc(2);
    t.push(d3);
    Disc d4 = t.pop();
    assertEquals(d4, d3);
  }

  @Test
  public void testPushDiscOnTower() throws TowerIsEmptyException, TowerIsFullException{
    Tower t = new Tower(3);
    Disc d1 = new Disc(3);
    assertEquals(t.getNbDisc(), 0);
    t.push(d1);
    Disc d2 = t.top();
    assertEquals(d2, d1);
    assertEquals(t.getNbDisc(), 1);
  }

  @Test
  public void testPopTower() throws TowerIsEmptyException, TowerIsFullException{
    Tower t = new Tower(3);
    Disc d1 = new Disc(3);
    Disc d2 = new Disc(2);
    Disc d3 = new Disc(1);
    t.push(d1);
    t.push(d2);
    t.push(d3);
    assertEquals(t.getNbDisc(), 3);
    Disc d4 = t.pop();
    assertEquals(d4, d3);
    assertEquals(t.getNbDisc(), 2);
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(TowerTest.class);
  }
}
