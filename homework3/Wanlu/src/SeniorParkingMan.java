import java.util.ArrayList;

public class SeniorParkingMan extends JuniorParkingMan{

    private ArrayList<ParkingLot> parkingLots;

    public SeniorParkingMan(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public int park(String plateNum) {
        double maxVacancyRatio = 0;
        int lotNumWithMaxVacancyRatio = 0;
        for (int parkingLotNum = 0;  parkingLotNum < parkingLots.size();  parkingLotNum++) {
            if (parkingLots.get(parkingLotNum).getVacancyRatio() > maxVacancyRatio) {
                maxVacancyRatio = parkingLots.get(parkingLotNum).getVacancyRatio();
                lotNumWithMaxVacancyRatio = parkingLotNum;
            }
        }
        return parkingLots.get(lotNumWithMaxVacancyRatio).park(plateNum);
    }
}
