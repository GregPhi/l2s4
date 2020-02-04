import org.junit.*;
import static org.junit.Assert.*;
import image.Pixel;
import image.color.GrayColor;

public class PixelTest{

  @Test
  public void Test(){
    GrayColor c1 = new GrayColor(0);
    GrayColor c2 = new GrayColor(255);
    Pixel p1 = new Pixel(c1);
    Pixel p2 = new Pixel(c2);
    Pixel p3 = new Pixel(c2);
    assertTrue(p2.colorDifference(p1) == 255);
    assertFalse(p2.equals(p1));
    assertTrue(p2.equals(p3));
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(PixelTest.class);
  }
}
