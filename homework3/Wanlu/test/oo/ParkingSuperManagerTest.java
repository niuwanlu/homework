package oo;

import oo.finders.SimpleFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class ParkingSuperManagerTest {

    private Packer superParkingManager;

    @Before
    public void setUp() throws Exception {
        Packer parkingManager1 = createParkingManager1();
        Packer parkingManager2 = createParkingManager2();
        ArrayList<Packer> parkingManagers = new ArrayList<Packer>();
        parkingManagers.add(parkingManager1);
        parkingManagers.add(parkingManager2);
        superParkingManager = new ParkingManager(parkingManagers);
    }

    private Packer createParkingManager1() {
        Packer parkingMan1 = createParkingManWithCapacityAndOccupation(8, 2);
        Packer parkingMan2 = createParkingManWithCapacityAndOccupation(10, 3);
        ArrayList<Packer> parkingMans = new ArrayList<Packer>();
        parkingMans.add(parkingMan1);
        parkingMans.add(parkingMan2);
        return new ParkingManager(parkingMans);
    }

    private Packer createParkingManager2() {
        Packer parkingMan1 = createParkingManWithCapacityAndOccupation(6, 2);
        Packer parkingMan2 = createParkingManWithCapacityAndOccupation(4, 1);
        ArrayList<Packer> parkingMans = new ArrayList<Packer>();
        parkingMans.add(parkingMan1);
        parkingMans.add(parkingMan2);
        return new ParkingManager(parkingMans);
    }

    private Packer createParkingManWithCapacityAndOccupation(int capacity, int occupation) {
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        Packer parkingMan = new ParkingMan(new SimpleFinder(), parkingLots);
        while (occupation > 0) {
            parkingMan.park("ShanA123");
            occupation--;
        }
        return parkingMan;
    }

    @Test
    public void testParkingSuperManagerParkCar() throws Exception {
        assertNotSame("0", superParkingManager.park("ShanA123"));
    }

    @Test
    public void testParkingSuperManagerGetCar() throws Exception {
        String serialNum = superParkingManager.park("ShanA123");
        assertEquals("ShanA123", superParkingManager.getCar(serialNum));
    }

    @Test
    public void testParkingSuperManagerReport() throws Exception {
        String expectedReport = "ParkingManager\n"
                + "-- ParkingManager\n"
                + "-- -- ParkingMan (2/8)\n"
                + "-- -- ParkingMan (3/10)\n"
                + "-- ParkingManager\n"
                + "-- -- ParkingMan (2/6)\n"
                + "-- -- ParkingMan (1/4)";
        assertEquals(expectedReport, superParkingManager.report().toString());
    }
}