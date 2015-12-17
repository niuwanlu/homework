package oo;

import oo.finders.IntermediateFinder;
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
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Packer parkingMan1 = new ParkingMan(new SimpleFinder(), parkingLots);
        Packer parkingMan2 = new ParkingMan(new IntermediateFinder(), parkingLots);
        ArrayList<Packer> parkingMans = new ArrayList<Packer>();
        parkingMans.add(parkingMan1);
        parkingMans.add(parkingMan2);
        Packer parkingManager1 = new ParkingManager(parkingMans);
        Packer parkingManager2 = new ParkingManager(parkingMans);
        ArrayList<Packer> parkingManagers = new ArrayList<Packer>();
        parkingManagers.add(parkingManager1);
        parkingManagers.add(parkingManager2);
        superParkingManager = new ParkingManager(parkingManagers);
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
}