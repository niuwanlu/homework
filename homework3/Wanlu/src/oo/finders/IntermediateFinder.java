package oo.finders;

import oo.ParkingLot;

import java.util.ArrayList;

public class IntermediateFinder implements Finder {

    @Override
    public ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLots) {
        int maxVacancy = 0;
        int lotNumWithMaxVacancy = 0;
        for (int parkingLotNum = 0; parkingLotNum < parkingLots.size(); parkingLotNum++) {
            int currentVacancy = parkingLots.get(parkingLotNum).getVacancy();
            if (currentVacancy > maxVacancy) {
                maxVacancy = currentVacancy;
                lotNumWithMaxVacancy = parkingLotNum;
            }
        }
        return parkingLots.get(lotNumWithMaxVacancy);
    }
}