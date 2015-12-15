package oo;

import oo.finders.Finder;

import java.util.ArrayList;

public class ParkingMan {

    protected Finder finder;
    protected ArrayList<ParkingLot> parkingLots;

    public ParkingMan(Finder finder, ArrayList<ParkingLot> parkingLots) {
        this.finder = finder;
        this.parkingLots = parkingLots;
    }

    public String park(String plateNum) {
        return finder.getParkingLot(parkingLots).park(plateNum);
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