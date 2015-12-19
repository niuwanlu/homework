package oo;

import oo.finders.Finder;

import java.util.ArrayList;

public class ParkingMan implements Packer{

    protected Finder finder;
    protected ArrayList<ParkingLot> parkingLots;
    public static String name = "ParkingMan";

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

    @Override
    public void generateReport(Report report) {
        report.parkingManReport(this);
    }

    public int getParkedCarNumber() {
        int parkedCarNumber = 0;
        for (ParkingLot parkingLot : parkingLots) {
            parkedCarNumber += parkingLot.getParkedCarNumber();
        }
        return parkedCarNumber;
    }

    public int getCapacity() {
        int capacity = 0;
        for (ParkingLot parkingLot : parkingLots) {
            capacity += parkingLot.getCapacity();
        }
        return capacity;
    }
}
