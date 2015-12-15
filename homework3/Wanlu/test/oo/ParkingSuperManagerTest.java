package oo;

import oo.finders.IntermediateFinder;
import oo.finders.SimpleFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class ParkingSuperManagerTest {

    private ParkingSuperManager parkingSuperManager;

    @Before
    public void setUp() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingMan parkingMan1 = new ParkingMan(new SimpleFinder(), parkingLots);
        ParkingMan parkingMan2 = new ParkingMan(new IntermediateFinder(), parkingLots);
        ArrayList<ParkingMan> parkingMans = new ArrayList<ParkingMan>();
        parkingMans.add(parkingMan1);
        parkingMans.add(parkingMan2);
        ParkingManager parkingManager1 = new ParkingManager(parkingMans);
        ParkingManager parkingManager2 = new ParkingManager(parkingMans);
        ArrayList<ParkingManager> parkingManagers = new ArrayList<ParkingManager>();
        parkingManagers.add(parkingManager1);
        parkingManagers.add(parkingManager2);
        parkingSuperManager = new ParkingSuperManager(parkingManagers);
    }

    @Test
    public void testParkingSuperManagerParkCar() throws Exception {
        assertNotSame("0", parkingSuperManager.park("ShanA123"));
    }

    @Test
    public void testParkingSuperManagerGetCar() throws Exception {
        String serialNum = parkingSuperManager.park("ShanA123");
        assertEquals("ShanA123", parkingSuperManager.getCar(serialNum));
    }
}