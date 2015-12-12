import java.util.ArrayList;

public class IntermediateParkingMan extends JuniorParkingMan{
    private ArrayList<ParkingLot> parkingLots;

    public IntermediateParkingMan(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public int park(String plateNum) {
        int lotNumWithMaxVacancy = getLotNumWithMaxVacancy();
        return parkingLots.get(lotNumWithMaxVacancy).park(plateNum);
    }

    private int getLotNumWithMaxVacancy() {
        int maxVacancy = 0;
        int lotNumWithMaxVacancy = 0;
        for (int parkingLotNum = 0;  parkingLotNum < parkingLots.size();  parkingLotNum++) {
            int currentVacancy = parkingLots.get(parkingLotNum).getVacancy();
            if (currentVacancy > maxVacancy) {
                maxVacancy = currentVacancy;
                lotNumWithMaxVacancy = parkingLotNum;
            }
        }
        return lotNumWithMaxVacancy;
    }

}
