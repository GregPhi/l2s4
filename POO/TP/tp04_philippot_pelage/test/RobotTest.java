import org.junit.*;
import static org.junit.Assert.*;

import robot.Robot;
import robot.util.Box;
import robot.util.ConveyerBelt;

public class RobotTest {

    @Test
    public void testTake() {
      Box someBox = new Box(10);
      Robot robot1 = new Robot();
      assertNull(robot1.getCarriedBox());
      robot1.take(someBox);
      assertNotNull(robot1.getCarriedBox());
    }

    @Test
    public void testCarryBox() {
      Box someBox = new Box(10);
      Robot robot1 = new Robot();
      assertFalse(robot1.carryBox());
      robot1.take(someBox);
      assertTrue(robot1.carryBox());
    }

    @Test
    public void test() {
      Box someBox = new Box(10);
      ConveyerBelt belt = new ConveyerBelt(50);
      Robot robot1 = new Robot();
      robot1.take(someBox);
      if(belt.isFull()){
        robot1.putOn(belt);
        assertEquals(robot1.getCarriedBox(),someBox);
      }else{
        robot1.putOn(belt);
        assertNull(robot1.getCarriedBox());
      }
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(BoxTest.class);
    }

}
