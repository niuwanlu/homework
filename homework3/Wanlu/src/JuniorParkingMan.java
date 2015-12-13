import java.util.ArrayList;

public class JuniorParkingMan {

    private ArrayList<ParkingLot> parkingLots;

    public JuniorParkingMan(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String park(String plateNum) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVacancy() > 0) {
                return parkingLot.park(plateNum);
            }
        }
        return "0";
    }

    public String getCar(String serialNum) {
        for (ParkingLot parkingLot : parkingLots) {
            String plateNum = parkingLot.leave(serialNum);
            if (plateNum != null) {
                return plateNum;
            }
        }
        return null;
    }
}
