import oo.ParkingMan;
import oo.ParkingLot;
import oo.finders.SimpleFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class ParkingManTest {

    private ArrayList<ParkingLot> parkingLots;
    private ParkingMan parkingMan;

    @Before
    public void setUp() throws Exception {
        parkingLots = new ArrayList<ParkingLot>(3);
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        parkingMan = new ParkingMan(new SimpleFinder(), parkingLots);
    }

    @Test
    public void testParkingManParkSuccess() throws Exception {
        assertNotSame("0", parkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillContinuouslyParkingInOneParkingLotWhenItIsNotFilled() throws Exception {
        parkingMan.park("ShanA123");
        parkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(0).getVacancy());
    }

    @Test
    public void testParkingManWillParkInTheSecondLotWhenFirstOneIsFilled() throws Exception {
        parkingMan.park("ShanA123");
        parkingMan.park("ShanA456");
        parkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(0).getVacancy());
        assertEquals(0, parkingLots.get(1).getVacancy());
    }

    @Test
    public void testGetCarSuccessfullyByCorrectSerialNum() throws Exception {
        String serialNum = parkingMan.park("ShanA123");
        assertEquals("ShanA123", parkingMan.getCar(serialNum));
    }

    @Test
    public void testGetCarUnsuccessfullyByIncorrectSerialNum() throws Exception {
        String serialNum = parkingMan.park("ShanA123");
        assertEquals(null, parkingMan.getCar(serialNum+"1"));
    }
}