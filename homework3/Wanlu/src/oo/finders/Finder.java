package oo.finders;

import oo.ParkingLot;

import java.util.ArrayList;

public interface Finder {
    ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLots);
}
