import oo.ParkingLot;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class ParkingLotTest {

    @Test
    public void testParkSuccessReturnSerialNumWhenThereIsSpace() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        assertNotSame("0", parkingLot.park("ShanA123"));
    }

    @Test
    public void testParkFailReturn0WhenThereIsNoSpace() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park("ShanA123");
        assertEquals("0", parkingLot.park("ShanA123"));
    }

    @Test
    public void testLeaveSuccessWhenSerialNumIsCorrect() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        String serialNum = parkingLot.park("ShanA123");
        assertEquals("ShanA123", parkingLot.leave(serialNum));
    }

    @Test
    public void testLeaveFailWhenSerialNumIsIncorrect() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        String serialNum = parkingLot.park("ShanA123");
        assertEquals(null, parkingLot.leave(serialNum+"1"));
    }

    @Test
    public void testGetVacancy() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.park("ShanA123");
        assertEquals(4, parkingLot.getVacancy());
    }

    @Test
    public void testGetVacancyRatio() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.park("ShanA123");
        assertEquals(0.8, parkingLot.getVacancyRatio());
    }
}