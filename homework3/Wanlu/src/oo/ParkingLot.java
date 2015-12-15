package oo;

import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {

    final private int capacity;
    private HashMap<String, String> parkingCars = new HashMap<String, String>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public String park(String plateNum) {
        if (getVacancy() > 0) {
            String serialNum = UUID.randomUUID().toString();
            parkingCars.put(serialNum, plateNum);
            return serialNum;
        }
        return "0";
    }

    public String leave(String serialNum) {
        return parkingCars.remove(serialNum);
    }

    public int getVacancy() {
        return capacity - parkingCars.size();
    }

    public double getVacancyRatio() {
        return (double)getVacancy()/capacity;
    }
}
