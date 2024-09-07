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
        Vehicle vehicle1 = new Vehicle("KA061282", VT.TWO);
        EntryGate entryGate = new EntryGate();
        Ticket ticket1 = entryGate.bookParking(vehicle);
        Ticket ticket2 = entryGate.bookParking(vehicle1);
        Thread.sleep(2000);
        ExitGate exitGate = new ExitGate();
        exitGate.setPriceCompute(VT.FOUR, new PerMilliSecPrice());
        exitGate.clearPayment(ticket1);
        exitGate.setPriceCompute(VT.TWO, new PerMilliSecPrice());
        exitGate.clearPayment(ticket2);

    }

    private static void init() {

    }
}
