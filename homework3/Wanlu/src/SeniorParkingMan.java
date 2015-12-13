import java.util.ArrayList;

public class SeniorParkingMan extends JuniorParkingMan{

    private ArrayList<ParkingLot> parkingLots;

    public SeniorParkingMan(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public String park(String plateNum) {
        int lotNumWithMaxVacancyRatio = getLotNumWithMaxVacancyRatio();
        return parkingLots.get(lotNumWithMaxVacancyRatio).park(plateNum);
    }

    private int getLotNumWithMaxVacancyRatio() {
        double maxVacancyRatio = 0;
        int lotNumWithMaxVacancyRatio = 0;
        for (int parkingLotNum = 0;  parkingLotNum < parkingLots.size();  parkingLotNum++) {
            double currentVacancyRatio = parkingLots.get(parkingLotNum).getVacancyRatio();
            if (currentVacancyRatio > maxVacancyRatio) {
                maxVacancyRatio = currentVacancyRatio;
                lotNumWithMaxVacancyRatio = parkingLotNum;
            }
        }
        return lotNumWithMaxVacancyRatio;
    }
}
