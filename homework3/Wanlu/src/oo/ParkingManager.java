package oo;

import java.util.ArrayList;

public class ParkingManager {
    private ArrayList<ParkingMan> parkingMans;

    public ParkingManager(ArrayList<ParkingMan> parkingMans) {
        this.parkingMans = parkingMans;
    }

    public String park(String plateNumer) {
        for (ParkingMan parkingMan : parkingMans) {
            String serialNum = parkingMan.park(plateNumer);
            if (!serialNum.equals("0")) {
                return serialNum;
            }
        }
        return "0";
    }

    public String getCar(String serialNum) {
        for (ParkingMan parkingMan : parkingMans) {
            String plateNum = parkingMan.getCar(serialNum);
            if (!(plateNum == null)) {
                return plateNum;
            }
        }
        return null;
    }
}
