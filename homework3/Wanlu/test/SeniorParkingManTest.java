import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        assertEquals(1, seniorParkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillParkToTheLotWithHighestVacancyRatio() throws Exception {
        parkingLots.get(0).park("ShanA123");
        parkingLots.get(1).park("ShanA234");
        seniorParkingMan.park("ShanA345");
        assertEquals(0, parkingLots.get(2).park("ShanA456"));
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        int serialNum1 = seniorParkingMan.park("ShanA123");
        int serialNum2 = seniorParkingMan.park("ShanA234");
        int serialNum3 = seniorParkingMan.park("ShanA345");
        assertEquals(true, seniorParkingMan.getCar("ShanA123", serialNum1));
        assertEquals(true, seniorParkingMan.getCar("ShanA234", serialNum2));
        assertEquals(true, seniorParkingMan.getCar("ShanA345", serialNum3));
    }
}