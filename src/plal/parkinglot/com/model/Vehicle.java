package plal.parkinglot.com.model;

import plal.parkinglot.com.util.VT;

public class Vehicle {
    private final String vehicleNo;
    private final VT type;

    public Vehicle(String vehicleNo, VT type) {
        this.vehicleNo = vehicleNo;
        this.type = type;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public VT getType() {
        return type;
    }
}
