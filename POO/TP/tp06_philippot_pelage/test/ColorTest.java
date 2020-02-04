import org.junit.*;
import static org.junit.Assert.*;
import image.color.GrayColor;

public class ColorTest{

  @Test
  public void Test(){
    GrayColor c0 = new GrayColor(100);
    GrayColor c1 = new GrayColor(255);
    GrayColor c2 = new GrayColor(-10);
    assertFalse(c0.equals(c2));
    assertTrue(c1.equals(c2));
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(ColorTest.class);
  }
}
