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
}