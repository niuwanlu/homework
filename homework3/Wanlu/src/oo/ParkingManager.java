package oo;

import java.util.ArrayList;

public class ParkingManager implements Packer {
    private ArrayList<Packer> packers;
    private static String name = "ParkingManager";

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
    public StringBuilder report() {
        StringBuilder report = new StringBuilder();
        report.append(name);
        for (Packer packer : packers) {
            String[] reportLines = packer.report().toString().split("\\n");
            for (String line : reportLines) {
                report.append("\n-- ").append(line);
            }
        }
        return report;
    }
}
