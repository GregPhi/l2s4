package rental;

import static org.junit.Assert.*;

import org.junit.Test;

public class MotorbikeTest {

  @Test
  public void getBrandTest(){
    Motorbike m1 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m2 = new Motorbike("brand2","model2",2010,200.0f,3);
    assertTrue(m1.getBrand()=="brand1");
    assertTrue(m2.getBrand()=="brand2");
  }

	@Test
	public void getModelTest(){
    Motorbike m1 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m2 = new Motorbike("brand2","model2",2010,200.0f,3);
    assertTrue("model1"==m1.getModel());
    assertTrue("model2"==m2.getModel());
	}

  @Test
  public void getProductionYearTest(){
    Motorbike m1 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m2 = new Motorbike("brand2","model2",2010,200.0f,3);
    assertTrue(2015==m1.getProductionYear());
    assertTrue(2010==m2.getProductionYear());
	}

  @Test
  public void getDailyPriceTest(){
    Motorbike m1 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m2 = new Motorbike("brand2","model2",2010,200.0f,3);
    assertTrue(100.0f==m1.getDailyPrice());
    assertTrue(200.0f==m2.getDailyPrice());
  }

  @Test
  public void getCapacityOfPassengersTest(){
    Motorbike m1 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m2 = new Motorbike("brand2","model2",2010,200.0f,3);
    assertTrue(4==m1.getCylindre());
    assertTrue(3==m2.getCylindre());
  }

  @Test
  public void equalsTest(){
    Motorbike m1 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m2 = new Motorbike("brand2","model2",2010,200.0f,3);
    Motorbike m3 = new Motorbike("brand1","model1",2015,100.0f,4);
    Motorbike m4 = new Motorbike("brand2","model2",2025,150.0f,7);
    assertTrue(m1.equals(m3));
    assertFalse(m1.equals(m2));
    assertFalse(m2.equals(m3));
    assertFalse(m2.equals(m4));
  }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.MotorbikeTest.class);
    }

}
