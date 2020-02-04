package rental;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

  @Test
  public void getBrandTest(){
    Car c1 = new Car("brand1","model1",2015,100.0f,4);
    Car c2 = new Car("brand2","model2",2010,200.0f,3);
    assertTrue(c1.getBrand()=="brand1");
    assertTrue(c2.getBrand()=="brand2");
  }

	@Test
	public void getModelTest(){
    Car c1 = new Car("brand1","model1",2015,100.0f,4);
    Car c2 = new Car("brand2","model2",2010,200.0f,3);
    assertTrue("model1"==c1.getModel());
    assertTrue("model2"==c2.getModel());
	}

  @Test
  public void getProductionYearTest(){
    Car c1 = new Car("brand1","model1",2015,100.0f,4);
    Car c2 = new Car("brand2","model2",2010,200.0f,3);
    assertTrue(2015==c1.getProductionYear());
    assertTrue(2010==c2.getProductionYear());
	}

  @Test
  public void getDailyPriceTest(){
    Car c1 = new Car("brand1","model1",2015,100.0f,4);
    Car c2 = new Car("brand2","model2",2010,200.0f,3);
    assertTrue(100.0f==c1.getDailyPrice());
    assertTrue(200.0f==c2.getDailyPrice());
  }

  @Test
  public void getCapacityOfPassengersTest(){
    Car c1 = new Car("brand1","model1",2015,100.0f,4);
    Car c2 = new Car("brand2","model2",2010,200.0f,3);
    assertTrue(4==c1.getCapacityOfPassengers());
    assertTrue(3==c2.getCapacityOfPassengers());
  }

  @Test
  public void equalsTest(){
    Car c1 = new Car("brand1","model1",2015,100.0f,4);
    Car c2 = new Car("brand2","model2",2010,200.0f,3);
    Car c3 = new Car("brand1","model1",2015,100.0f,4);
    Car c4 = new Car("brand2","model2",2025,150.0f,7);
    assertTrue(c1.equals(c3));
    assertFalse(c1.equals(c2));
    assertFalse(c2.equals(c3));
    assertFalse(c2.equals(c4));
  }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.CarTest.class);
    }

}
