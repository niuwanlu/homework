import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        parkingMan = new ParkingMan(parkingLots);
    }

    @Test
    public void testParkingManParkSuccess() throws Exception {
        assertEquals(1, parkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillContinuouslyParkingInOneParkingLotWhenItIsNotFilled() throws Exception {
        parkingMan.park("ShanA123");
        parkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(0).park("ShanA789"));
    }

    @Test
    public void testParkingManWillParkInTheSecondLotWhenFirstOneIsFilled() throws Exception {
        parkingMan.park("ShanA123");
        parkingMan.park("ShanA456");
        parkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(1).park("ShanA789"));
    }

    @Test
    public void testParkingManWillParkInTheThirdLotWhenFirstAndSecondOneAreFilled() throws Exception {
        parkingMan.park("ShanA123");
        parkingMan.park("ShanA234");
        parkingMan.park("ShanA345");
        parkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(2).park("ShanA789"));
    }

    @Test
    public void testSerialNumContainsParkingLotNum() throws Exception {
        int serialNum1 = parkingMan.park("ShanA123");
        int serialNum2 = parkingMan.park("ShanA234");
        int serialNum3 = parkingMan.park("ShanA345");
        assertEquals(0, serialNum1/10);
        assertEquals(0, serialNum2/10);
        assertEquals(1, serialNum3 / 10);
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        int serialNum = parkingMan.park("ShanA123");
        assertEquals(true, parkingMan.getCar("ShanA123", serialNum));
    }
}