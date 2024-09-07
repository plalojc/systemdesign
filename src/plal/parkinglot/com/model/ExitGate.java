package plal.parkinglot.com.model;

import plal.parkinglot.com.factory.ParkingChargeComputeFactory;
import plal.parkinglot.com.factory.ParkingManagerFactory;
import plal.parkinglot.com.manager.ParkingManager;
import plal.parkinglot.com.strategy.VehicleParkingChargeCompute;

public class ExitGate {
    private int gateNo;

    public void clearPayment(Ticket ticket) {
        VehicleParkingChargeCompute vpc = ParkingChargeComputeFactory.getParkingChargeComputeFactory(ticket);
        double amount = vpc.parkingChargeCompute(ticket);
        ParkingManager pm = ParkingManagerFactory.getParkingManager(ticket.getVehicle().getType());
        pm.removeVehicle(ticket.getParkingNo());
    }
}
