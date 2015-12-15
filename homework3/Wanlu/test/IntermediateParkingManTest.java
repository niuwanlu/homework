import oo.ParkingMan;
import oo.ParkingLot;
import oo.finders.IntermediateFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class IntermediateParkingManTest {

    private ArrayList<ParkingLot> parkingLots;
    private ParkingMan parkingMan;

    @Before
    public void setUp() throws Exception {
        parkingLots = new ArrayList<ParkingLot>(3);
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(1));
        parkingMan = new ParkingMan(new IntermediateFinder(), parkingLots);
    }

    @Test
    public void testParkingManParkSuccess() throws Exception {
        assertNotSame("0", parkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillParkCanInTheLotHavingMostVacancy() throws Exception {
        parkingMan.park("ShanA123");
        assertEquals(2, parkingLots.get(1).getVacancy());
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        String serialNum = parkingMan.park("ShanA123");
        assertEquals("ShanA123", parkingMan.getCar(serialNum));
    }
}