import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ParkingLotTest {

    @Test
    public void testParkSuccessReturnSerialNumWhenThereIsSpace() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        assertEquals(1, parkingLot.park("ShanA123"));
    }

    @Test
    public void testParkFailReturn0WhenThereIsNoSpace() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park("ShanA123");
        assertEquals(0, parkingLot.park("ShanA123"));
    }

    @Test
    public void testLeaveSuccessWhenSerialNumIsCorrect() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        int serialNum = parkingLot.park("ShanA123");
        assertEquals(true, parkingLot.leave("ShanA123", serialNum));
    }

    @Test
    public void testLeaveFailWhenSerialNumIsIncorrect() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        int serialNum = parkingLot.park("ShanA123");
        parkingLot.park("ShanA567");
        assertEquals(false, parkingLot.leave("ShanA456", serialNum));
    }

    @Test
    public void testLeaveFailWhenSerialNumDoesNotExist() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park("ShanA123");
        assertEquals(false, parkingLot.leave("ShanA123", 2));
    }
}