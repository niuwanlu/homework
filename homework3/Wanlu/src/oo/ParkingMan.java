package oo;

import oo.finders.Finder;

import java.util.ArrayList;

public class ParkingMan implements Packer{

    protected Finder finder;
    protected ArrayList<ParkingLot> parkingLots;
    private static String name = "ParkingMan";

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

    public String report() {
        return name + " (" + String.valueOf(getParkedCarNumber()) + "/" + String.valueOf(getCapacity()) + ")";
    }

    private int getParkedCarNumber() {
        int parkedCarNumber = 0;
        for (ParkingLot parkingLot : parkingLots) {
            parkedCarNumber += parkingLot.getParkedCarNumber();
        }
        return parkedCarNumber;
    }

    private int getCapacity() {
        int capacity = 0;
        for (ParkingLot parkingLot : parkingLots) {
            capacity += parkingLot.getCapacity();
        }
        return capacity;
    }
}
