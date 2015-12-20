package oo;

import java.util.ArrayList;

public class Report {
    private StringBuilder report;

    public Report(StringBuilder report) {
        this.report = report;
    }

    public StringBuilder getReport() {
        return report;
    }

    public void parkingManagerReport(ArrayList<Packer> packers) {
        report.append(ParkingManager.name);
        for (Packer packer : packers) {
            StringBuilder subReport = new StringBuilder();
            packer.generateReport(new Report(subReport));
            String[] reportLines = subReport.toString().split("\\n");
            for (String line : reportLines) {
                report.append("\n-- ").append(line);
            }
        }
    }

    public void parkingManReport(ParkingMan parkingMan) {
        report.append(ParkingMan.name).append(" (").append(String.valueOf(parkingMan.getParkedCarNumber())).append("/").append(String.valueOf(parkingMan.getCapacity())).append(")");
    }
}
