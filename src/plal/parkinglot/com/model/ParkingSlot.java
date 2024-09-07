package plal.parkinglot.com.model;

public class ParkingSlot {
    private int parkingNo;
    private boolean isEmpty;
    private int price;

    private Vehicle vehicle;

    public ParkingSlot(int parkingNo, int price) {
        this.parkingNo = parkingNo;
        this.price = price;
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
}
