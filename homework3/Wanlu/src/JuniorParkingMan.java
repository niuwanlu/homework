import java.util.ArrayList;

public class JuniorParkingMan {

    protected ArrayList<ParkingLot> parkingLots;

    public JuniorParkingMan(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public int park(String plateNum) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVacancy() > 0) {
                return parkingLot.park(plateNum);
            }
        }
        return 0;
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
