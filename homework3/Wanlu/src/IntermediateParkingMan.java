import java.util.ArrayList;

public class IntermediateParkingMan extends JuniorParkingMan{
    private ArrayList<ParkingLot> parkingLots;

    public IntermediateParkingMan(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
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

}
