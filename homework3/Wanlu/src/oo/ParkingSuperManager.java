package oo;

import java.util.ArrayList;

public class ParkingSuperManager {
    private ArrayList<ParkingManager> parkingManagers;

    public ParkingSuperManager(ArrayList<ParkingManager> parkingManagers) {
        this.parkingManagers = parkingManagers;
    }

    public String park(String plateNumer) {
        for (ParkingManager parkingManager : parkingManagers) {
            String serialNum = parkingManager.park(plateNumer);
            if (!serialNum.equals("0")) {
                return serialNum;
            }
        }
        return "0";
    }

    public String getCar(String serialNum) {
        for (ParkingManager parkingManager : parkingManagers) {
            String plateNum = parkingManager.getCar(serialNum);
            if (!(plateNum == null)) {
                return plateNum;
            }
        }
        return null;
    }
}
