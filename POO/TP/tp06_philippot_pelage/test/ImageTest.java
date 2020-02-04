import org.junit.*;
import static org.junit.Assert.*;
import image.*;
import image.color.GrayColor;

public class ImageTest{

  @Test
  public void Test(){
    boolean a = true;
    Image img = new Image(100, 100);
    GrayColor color = new GrayColor(100);
    img.changeColorPixel(50,50,color);
    try{
      img.changeColorPixel(50,50,color);
      //assertFalse(a);
    }catch(UnknownPixelException e){

    }
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(ImageTest.class);
  }
}
