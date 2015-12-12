import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class IntermediateParkingManTest {


    private ArrayList<ParkingLot> parkingLots;
    private IntermediateParkingMan intermediateParkingMan;

    @Before
    public void setUp() throws Exception {
        parkingLots = new ArrayList<ParkingLot>(3);
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(1));
        intermediateParkingMan = new IntermediateParkingMan(parkingLots);
    }

    @Test
    public void testParkingManParkSuccess() throws Exception {
        assertEquals(1, intermediateParkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillParkCanInTheLotHavingMostVacancy() throws Exception {
        intermediateParkingMan.park("ShanA123");
        assertNotSame(0, parkingLots.get(1).park("ShanA234"));
        assertNotSame(0, parkingLots.get(1).park("ShanA345"));
        assertEquals(0, parkingLots.get(1).park("ShanA345"));
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        int serialNum1 = intermediateParkingMan.park("ShanA123");
        int serialNum2 = intermediateParkingMan.park("ShanA234");
        int serialNum3 = intermediateParkingMan.park("ShanA345");
        assertEquals(true, intermediateParkingMan.getCar("ShanA123", serialNum1));
        assertEquals(true, intermediateParkingMan.getCar("ShanA234", serialNum2));
        assertEquals(true, intermediateParkingMan.getCar("ShanA345", serialNum3));
    }
}