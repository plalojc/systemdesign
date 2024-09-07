package plal.parkinglot.com.model;

import plal.parkinglot.com.factory.ParkingChargeComputeFactory;
import plal.parkinglot.com.factory.ParkingManagerFactory;
import plal.parkinglot.com.manager.ParkingManager;
import plal.parkinglot.com.strategy.PriceStrategy;
import plal.parkinglot.com.strategy.VehicleParkingChargeCompute;
import plal.parkinglot.com.util.VT;

public class ExitGate {
    private int gateNo;

    public void setPriceCompute(VT type, PriceStrategy ps) {
        VehicleParkingChargeCompute vpc = ParkingChargeComputeFactory.getParkingChargeComputeFactory(type);
        vpc.setPriceStrategy(ps);
    }
    public void clearPayment(Ticket ticket) {
        if(ticket.isValidTicket()) {
            VehicleParkingChargeCompute vpc = ParkingChargeComputeFactory.getParkingChargeComputeFactory(ticket);
            double amount = vpc.parkingChargeCompute(ticket);
            System.out.println("Amount Paid :" + amount);
            ParkingManager pm = ParkingManagerFactory.getParkingManager(ticket.getVehicle().getType());
            pm.removeVehicle(ticket.getParkingNo());
            ticket.invalidateTicket();
        }
    }
}
