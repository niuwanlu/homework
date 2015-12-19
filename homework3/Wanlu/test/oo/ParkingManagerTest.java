package oo;

import oo.finders.IntermediateFinder;
import oo.finders.SimpleFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class ParkingManagerTest {

    private Packer parkingManager;
    private Packer parkingMan1;
    private Packer parkingMan2;

    @Before
    public void setUp() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots1 = new ArrayList<ParkingLot>();
        parkingLots1.add(parkingLot1);
        parkingLots1.add(parkingLot2);

        ParkingLot parkingLot3 = new ParkingLot(4);
        ParkingLot parkingLot4 = new ParkingLot(4);
        ArrayList<ParkingLot> parkingLots2 = new ArrayList<ParkingLot>();
        parkingLots2.add(parkingLot3);
        parkingLots2.add(parkingLot4);

        parkingMan1 = new ParkingMan(new SimpleFinder(), parkingLots1);
        parkingMan2 = new ParkingMan(new IntermediateFinder(), parkingLots2);
        ArrayList<Packer> parkingMans = new ArrayList<Packer>();
        parkingMans.add(parkingMan1);
        parkingMans.add(parkingMan2);
        parkingManager = new ParkingManager(parkingMans);
    }

    @Test
    public void testParkingManagerParkCar() throws Exception {
        assertNotSame("0", parkingManager.park("ShanA123"));
    }

    @Test
    public void testParkingManagerGetCar() throws Exception {
        String serialNum = parkingManager.park("ShanA123");
        assertEquals("ShanA123", parkingManager.getCar(serialNum));
    }

    @Test
    public void testReport() throws Exception {
        parkingMan1.park("ShanA123");
        parkingMan1.park("ShanA234");
        parkingMan2.park("ShanA345");
        parkingMan2.park("ShanA456");
        parkingMan2.park("ShanA567");
        String expected = "ParkingManager\n-- ParkingMan (2/6)\n-- ParkingMan (3/8)";
        assertEquals(expected, parkingManager.report().toString());
    }
}