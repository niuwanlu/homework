package oo;

import java.util.ArrayList;

public class ParkingManager implements Packer {
    private ArrayList<Packer> packers;
    public static String name = "ParkingManager";

    public ParkingManager(ArrayList<Packer> packers) {
        this.packers = packers;
    }

    @Override
    public String park(String plateNumer) {
        for (Packer parkingMan : packers) {
            String serialNum = parkingMan.park(plateNumer);
            if (!serialNum.equals("0")) {
                return serialNum;
            }
        }
        return "0";
    }

    @Override
    public String getCar(String serialNum) {
        for (Packer parkingMan : packers) {
            String plateNum = parkingMan.getCar(serialNum);
            if (!(plateNum == null)) {
                return plateNum;
            }
        }
        return null;
    }

    @Override
    public void generateReport(Report report) {
        report.parkingManagerReport(packers);
    }

}
