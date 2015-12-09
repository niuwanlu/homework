import java.util.HashMap;

public class ParkingLot {

    private int capacity;
    private int takenNum;
    private int serialNum;
    private HashMap<Integer, String> parkingCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.takenNum = 0;
        this.serialNum = 0;
        parkingCars = new HashMap<Integer, String>(capacity);
    }

    public int park(String plateNum) {
        if (takenNum < capacity) {
            takenNum++;
            serialNum++;
            parkingCars.put(serialNum, plateNum);
            return serialNum;
        }
        return 0;
    }

    public boolean leave(String plateNum, int serialNum) {
        if (parkingCars.get(serialNum) == null) {
            return false;
        }

        if (parkingCars.get(serialNum).equals(plateNum)) {
            parkingCars.remove(serialNum);
            takenNum--;
            return true;
        }

        return false;
    }
}
