package oo.finders;

import oo.ParkingLot;

import java.util.ArrayList;

public class SimpleFinder implements Finder {

    @Override
    public ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVacancy() > 0) {
                return parkingLot;
            }
        }
        return parkingLots.get(0);
    }
}