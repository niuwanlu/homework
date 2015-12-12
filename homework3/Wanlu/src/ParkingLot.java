import java.util.HashMap;

public class ParkingLot {

    private int capacity;
    private int serialNum;
    private HashMap<Integer, String> parkingCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.serialNum = 0;
        parkingCars = new HashMap<Integer, String>();
    }

    public int park(String plateNum) {
        if (parkingCars.size() < capacity) {
            serialNum++;
            parkingCars.put(serialNum, plateNum);
            return serialNum;
        }
        return 0;
    }

    public boolean leave(String plateNum, int serialNum) {
        if (plateNum.equals(parkingCars.get(serialNum))) {
            parkingCars.remove(serialNum);
            return true;
        }
        return false;
    }

    public int getEmptySpaceCount() {
        return capacity - parkingCars.size();
    }

}
