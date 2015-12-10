import java.util.ArrayList;

public class ParkingMan {

    public static final int MAX_LOT_CAPACITY = 10;
    private ArrayList<ParkingLot> parkingLots;

    public ParkingMan(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public int park(String plateNum) {
        int serialNum = 0;
        for (int i = 0; i < parkingLots.size(); i++) {
            ParkingLot parkingLot = parkingLots.get(i);
            serialNum = parkingLot.park(plateNum);
            if (serialNum != 0) {
                return i*MAX_LOT_CAPACITY + serialNum;
            }
        }
        return serialNum;
    }

    public boolean getCar(String plateNum, int serialNum) {
        int lotNum = serialNum / 10;
        int subSerialNum = serialNum % MAX_LOT_CAPACITY;
        return parkingLots.get(lotNum).leave(plateNum, subSerialNum);
    }
}
