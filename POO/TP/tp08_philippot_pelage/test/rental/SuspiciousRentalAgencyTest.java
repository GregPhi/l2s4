package rental;
import rental.SuspiciousRentalAgency;
import static org.junit.Assert.*;

import org.junit.Test;

public class SuspiciousRentalAgencyTest {

	@Test
	public void testRentVehicle() throws UnknowVehicleException{
    Client c1 = new Client("client1",20);
    Client c2 = new Client("client2",30);
    Vehicle v1 = new Vehicle("brand1","model1",2015,100);
    Vehicle v2 = new Vehicle("brand2","model2",2000,200);
    SuspiciousRentalAgency agency = new SuspiciousRentalAgency();
    agency.addVehicle(v1);
    agency.addVehicle(v2);
    assertTrue(agency.rentVehicle(c1,v1) == 110);
    assertTrue(agency.rentVehicle(c2,v2) == 200);
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.SuspiciousRentalAgencyTest.class);
    }

}
