package plal.parkinglot.com.model;

public class ParkingSlot {
    private int parkingNo;
    private boolean isEmpty;

    private Vehicle vehicle;

    public ParkingSlot(int parkingNo) {
        this.parkingNo = parkingNo;
        this.isEmpty = true;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public boolean isParkingEmpty() {
        return isEmpty;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
