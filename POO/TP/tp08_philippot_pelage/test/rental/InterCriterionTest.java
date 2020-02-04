package rental;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterCriterionTest {

  @Test
  public void testInterCriterion() {
    assertNotNull(new InterCriterion());
  }

	@Test
	public void testisSatisfiedBy() {
    BrandCriterion crit1 = new BrandCriterion("brand1");
    PriceCriterion crit2 = new PriceCriterion(150);
    InterCriterion list = new InterCriterion();
    Vehicle v1 = new Vehicle("brand1","model1",2015,100);
    Vehicle v2 = new Vehicle("brand2","model2",2000,200);
    list.addCriterion(crit1);
    assertTrue(list.isSatisfiedBy(v1));
    assertFalse(list.isSatisfiedBy(v2));
    list.addCriterion(crit2);
    assertTrue(list.isSatisfiedBy(v1));
    assertFalse(list.isSatisfiedBy(v2));
  }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.InterCriterionTest.class);
    }

}
