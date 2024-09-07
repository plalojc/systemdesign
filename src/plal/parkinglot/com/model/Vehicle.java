package plal.parkinglot.com.model;

import plal.parkinglot.com.util.VT;

public class Vehicle {
    private final int vehicleNo;
    private final VT type;

    public Vehicle(int vehicleNo, VT type) {
        this.vehicleNo = vehicleNo;
        this.type = type;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public VT getType() {
        return type;
    }
}
