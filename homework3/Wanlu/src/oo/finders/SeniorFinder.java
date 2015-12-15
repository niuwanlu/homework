package oo.finders;

import oo.ParkingLot;

import java.util.ArrayList;

public class SeniorFinder implements Finder {

    @Override
    public ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLots) {
        double maxVacancyRatio = 0;
        int lotNumWithMaxVacancyRatio = 0;
        for (int parkingLotNum = 0; parkingLotNum < parkingLots.size(); parkingLotNum++) {
            double currentVacancyRatio = parkingLots.get(parkingLotNum).getVacancyRatio();
            if (currentVacancyRatio > maxVacancyRatio) {
                maxVacancyRatio = currentVacancyRatio;
                lotNumWithMaxVacancyRatio = parkingLotNum;
            }
        }
        return parkingLots.get(lotNumWithMaxVacancyRatio);
    }
}