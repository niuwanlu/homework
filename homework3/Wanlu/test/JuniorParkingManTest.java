import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotSame;
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
        assertNotSame("0", juniorParkingMan.park("ShanA123"));
    }

    @Test
    public void testParkingManWillContinuouslyParkingInOneParkingLotWhenItIsNotFilled() throws Exception {
        juniorParkingMan.park("ShanA123");
        juniorParkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(0).getVacancy());
    }

    @Test
    public void testParkingManWillParkInTheSecondLotWhenFirstOneIsFilled() throws Exception {
        juniorParkingMan.park("ShanA123");
        juniorParkingMan.park("ShanA456");
        juniorParkingMan.park("ShanA456");
        assertEquals(0, parkingLots.get(0).getVacancy());
        assertEquals(0, parkingLots.get(1).getVacancy());
    }

    @Test
    public void testGetCarSuccessfullyByCorrectSerialNum() throws Exception {
        String serialNum = juniorParkingMan.park("ShanA123");
        assertEquals("ShanA123", juniorParkingMan.getCar(serialNum));
    }

    @Test
    public void testGetCarUnsuccessfullyByIncorrectSerialNum() throws Exception {
        String serialNum = juniorParkingMan.park("ShanA123");
        assertEquals(null, juniorParkingMan.getCar(serialNum+"1"));
    }
}