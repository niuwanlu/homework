import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class JuniorParkingManTest {

    private ArrayList<ParkingLot> parkingLots;
    private JuniorParkingMan juniorParkingMan;

    @Before
    public void setUp() throws Exception {
        parkingLots = new ArrayList<ParkingLot>(3);
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        juniorParkingMan = new JuniorParkingMan(parkingLots);
    }

    @Test
    public void testParkingManParkSuccess() throws Exception {
        assertEquals(1, juniorParkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillContinuouslyParkingInOneParkingLotWhenItIsNotFilled() throws Exception {
        juniorParkingMan.park("ShanA123");
        juniorParkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(0).park("ShanA789"));
    }

    @Test
    public void testParkingManWillParkInTheSecondLotWhenFirstOneIsFilled() throws Exception {
        juniorParkingMan.park("ShanA123");
        juniorParkingMan.park("ShanA456");
        juniorParkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(1).park("ShanA789"));
    }

    @Test
    public void testParkingManWillParkInTheThirdLotWhenFirstAndSecondOneAreFilled() throws Exception {
        juniorParkingMan.park("ShanA123");
        juniorParkingMan.park("ShanA234");
        juniorParkingMan.park("ShanA345");
        juniorParkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(2).park("ShanA789"));
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        int serialNum1 = juniorParkingMan.park("ShanA123");
        int serialNum2 = juniorParkingMan.park("ShanA234");
        int serialNum3 = juniorParkingMan.park("ShanA345");
        assertEquals(true, juniorParkingMan.getCar("ShanA123", serialNum1));
        assertEquals(true, juniorParkingMan.getCar("ShanA234", serialNum2));
        assertEquals(true, juniorParkingMan.getCar("ShanA345", serialNum3));
    }
}