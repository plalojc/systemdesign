package plal.parkinglot.com.demo;

import plal.parkinglot.com.model.EntryGate;
import plal.parkinglot.com.model.ExitGate;
import plal.parkinglot.com.model.Ticket;
import plal.parkinglot.com.model.Vehicle;
import plal.parkinglot.com.strategy.PerMilliSecPrice;
import plal.parkinglot.com.util.VT;

public class ParkingLot {
    public static void main(String[] args) throws InterruptedException {
        Vehicle vehicle = new Vehicle("KA061222", VT.FOUR);
        EntryGate entryGate = new EntryGate();
        Ticket ticket = entryGate.bookParking(vehicle);
        Thread.sleep(2000);
        ExitGate exitGate = new ExitGate();
        exitGate.setPriceCompute(VT.FOUR, new PerMilliSecPrice());
        exitGate.clearPayment(ticket);

    }

    private static void init() {

    }
}
