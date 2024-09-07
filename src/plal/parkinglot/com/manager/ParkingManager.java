package plal.parkinglot.com.manager;

import plal.parkinglot.com.model.ParkingSlot;
import plal.parkinglot.com.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingManager {
    private List<ParkingSlot> parkingList;
    private int parkingCapacity;

    public ParkingManager(int capacity){
        parkingList = new ArrayList<>(capacity);
        this.parkingCapacity = capacity;
    }

    protected List<ParkingSlot> getParkingList() {
        return parkingList;
    }

    public ParkingSlot findParkingSpace(){
        if(!isParkingFull()){
            return getParkingList().stream().filter(ParkingSlot::isParkingEmpty).findFirst().get();
        }
        return null;
    }

    public void addParkingSlot(int additionalCapacity) {
        this.parkingCapacity += additionalCapacity;
    }

    public void removeParkingSlot(int removeCapacity) {
        this.parkingCapacity -= removeCapacity;
    }

    public void ParkVehicle(ParkingSlot slot, Vehicle vehicle) {
        slot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSlot slot) {
        slot.removeVehicle();
    }

    public boolean isParkingFull() {
       return  parkingList.size() == parkingCapacity;
    }
}
