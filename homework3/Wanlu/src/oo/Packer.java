package oo;

public interface Packer {
    String park(String plateNum);

    String getCar(String serialNum);

    void generateReport(Report report);
}
