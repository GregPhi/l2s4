import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.*;

/**
 * Class DiscTest :
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 24 fevrier 2017
 */

public class DiscTest{

  @Test
  public void testSize(){
    Disc d = new Disc(5);
    assertEquals(d.getSize(),5);
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(DiscTest.class);
  }
}
