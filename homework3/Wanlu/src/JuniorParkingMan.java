import java.util.ArrayList;

public class JuniorParkingMan {

    protected ArrayList<ParkingLot> parkingLots;

    public JuniorParkingMan(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public int park(String plateNum) {
        int serialNum = 0;
        for (ParkingLot parkingLot : parkingLots) {
            serialNum = parkingLot.park(plateNum);
            if (serialNum != 0) {
                break;
            }
        }
        return serialNum;
    }

    public boolean getCar(String plateNum, int serialNum) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.leave(plateNum, serialNum)) {
                return true;
            }
        }
        return false;
    }
}
