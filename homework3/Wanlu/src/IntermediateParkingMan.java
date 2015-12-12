import java.util.ArrayList;

public class IntermediateParkingMan {
    private ArrayList<ParkingLot> parkingLots;

    public IntermediateParkingMan(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public int park(String plateNum) {
        int maxVacancy = 0;
        int lotNumWithMaxVacancy = 0;
        for (int parkingLotNum = 0;  parkingLotNum < parkingLots.size();  parkingLotNum++) {
            if (parkingLots.get(parkingLotNum).getVacancy() > maxVacancy) {
                maxVacancy = parkingLots.get(parkingLotNum).getVacancy();
                lotNumWithMaxVacancy = parkingLotNum;
            }
        }
        return parkingLots.get(lotNumWithMaxVacancy).park(plateNum);
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
