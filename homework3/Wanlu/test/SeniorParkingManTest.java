import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class SeniorParkingManTest {

    private ArrayList<ParkingLot> parkingLots;
    private SeniorParkingMan seniorParkingMan;

    @Before
    public void setUp() throws Exception {
        parkingLots = new ArrayList<ParkingLot>(3);
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(1));
        seniorParkingMan = new SeniorParkingMan(parkingLots);
    }

    @Test
    public void testParkingManParkSuccess() throws Exception {
        assertNotSame("0", seniorParkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillParkToTheLotWithHighestVacancyRatio() throws Exception {
        parkingLots.get(0).park("ShanA123");
        parkingLots.get(1).park("ShanA234");
        assertEquals(1, parkingLots.get(2).getVacancy());
        seniorParkingMan.park("ShanA345");
        assertEquals(0, parkingLots.get(2).getVacancy());
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        String serialNum = seniorParkingMan.park("ShanA123");
        assertEquals("ShanA123", seniorParkingMan.getCar(serialNum));
    }
}