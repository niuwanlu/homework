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
        assertNotSame("0", intermediateParkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillParkCanInTheLotHavingMostVacancy() throws Exception {
        intermediateParkingMan.park("ShanA123");
        assertEquals(2, parkingLots.get(1).getVacancy());
    }

    @Test
    public void testGetCarBySerialNum() throws Exception {
        String serialNum = intermediateParkingMan.park("ShanA123");
        assertEquals("ShanA123", intermediateParkingMan.getCar(serialNum));
    }
}