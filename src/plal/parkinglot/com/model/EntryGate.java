package plal.parkinglot.com.model;

import plal.parkinglot.com.factory.ParkingManagerFactory;
import plal.parkinglot.com.manager.ParkingManager;

public class EntryGate {
    private int gateNo;


    public Ticket bookParking(Vehicle vehicle) {
        ParkingManager pm = ParkingManagerFactory.getParkingManager(vehicle.getType());
        ParkingSlot ps = pm.findParkingSpace();
        ps.parkVehicle(vehicle);
        return generateTicket(ps);
    }

    public boolean isParkingAvailable(Vehicle vehicle) {
        return !ParkingManagerFactory.getParkingManager(vehicle.getType()).isParkingFull();
    }

    private Ticket generateTicket(ParkingSlot slot) {
        Ticket ticket = new Ticket();
        ticket.setParkingNo(slot);
        ticket.setVehicle(slot.getVehicle());
        ticket.setEntryTime(System.currentTimeMillis());
        return ticket;
    }
}
