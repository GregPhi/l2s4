package rental;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RentalAgencyTest{

  private Client c1;
  private Client c2;
  private Criterion crit1;
  private Criterion crit2;
  private Vehicle v1;
  private Vehicle v2;
  private RentalAgency agency;

  @Before
  public void before(){
    this.c1 = new Client("Client1",20);
    this.c2 = new Client("Client1",30);
    this.crit1 = new BrandCriterion("brand1");
    this.crit2 = new PriceCriterion(150);
    this.v1 = new Vehicle("brand1","model1",2015,100);
    this.v2 = new Vehicle("brand2","model2",2000,200);
    this.agency = new RentalAgency();
    this.agency.addVehicle(this.v1);
    this.agency.addVehicle(this.v2);
  }

  @Test
  public void testSelect(){
    assertFalse(this.agency.select(this.crit2).isEmpty());
  }

  @Test
  public void testRentVehicle() throws UnknowVehicleException{
    assertTrue(this.agency.rentVehicle(this.c1,this.v1) == 100);
  }

  @Test
  public void testhasRentedVehicle() throws UnknowVehicleException{
    this.agency.rentVehicle(this.c1,this.v1);
    assertTrue(this.agency.hasRentedAVehicle(this.c1));
    assertFalse(this.agency.hasRentedAVehicle(this.c2));
  }

  @Test
  public void testIsRented() throws UnknowVehicleException{
    this.agency.rentVehicle(this.c1,this.v1);
    assertTrue(this.agency.isRented(this.v1));
  }

  @Test
  public void testReturnVehicle() throws UnknowVehicleException{
    this.agency.rentVehicle(this.c1,this.v1);
    this.agency.returnVehicle(this.c1);
    assertFalse(this.agency.hasRentedAVehicle(this.c1));
  }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
    }

}
