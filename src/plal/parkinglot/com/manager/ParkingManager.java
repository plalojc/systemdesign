package plal.parkinglot.com.manager;

import plal.parkinglot.com.model.ParkingSlot;
import plal.parkinglot.com.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingManager {
    private final List<ParkingSlot> parkingList;
    private int parkingCapacity;
    private int parkedVehicleCount;

    public ParkingManager(int capacity){
        this.parkingList = new ArrayList<>(capacity);
        this.parkingCapacity = capacity;
        for(int i=1; i<=capacity; i++) {
            parkingList.add(new ParkingSlot(i));
        }
    }

    protected List<ParkingSlot> getParkingList() {
        return parkingList;
    }

    public ParkingSlot findParkingSpace(){
        ParkingSlot ps = null;
        if(!isParkingFull()){
            //ps = new ParkingSlot(getParkingList().size()+1);
            ps = getParkingList().stream().filter(ParkingSlot::isParkingEmpty).findFirst().get();
        }
        return ps;
    }

    public void addParkingSlot(int additionalCapacity) {
        this.parkingCapacity += additionalCapacity;
    }

    public void removeParkingSlot(int removeCapacity) {
        this.parkingCapacity -= removeCapacity;
    }

    public void ParkVehicle(ParkingSlot slot, Vehicle vehicle) {
        slot.parkVehicle(vehicle);
        parkedVehicleCount++;
    }

    public void removeVehicle(ParkingSlot slot) {
        slot.removeVehicle();
        parkedVehicleCount--;
    }

    public boolean isParkingFull() {
       return  parkedVehicleCount == parkingCapacity;
    }
}
