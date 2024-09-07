package plal.parkinglot.com.factory;

import plal.parkinglot.com.model.Ticket;
import plal.parkinglot.com.strategy.*;
import plal.parkinglot.com.util.VT;

import java.util.HashMap;
import java.util.Map;

public class ParkingChargeComputeFactory {
    private static Map<VT, VehicleParkingChargeCompute> cache = new HashMap<>();

    private ParkingChargeComputeFactory() {}

    public static VehicleParkingChargeCompute getParkingChargeComputeFactory(Ticket ticket) {
        VT type = ticket.getVehicle().getType();
        VehicleParkingChargeCompute vpc = cache.get(type);
        if(vpc != null) return vpc;
        vpc = switch (type) {
            case TWO -> new TwoWParkingChargeCompute(new PerMinutePrice());
            case FOUR -> new FourWParkingChargeCompute(new PerHourPrice());
        };
        cache.put(type, vpc);
        return vpc;
    }

    public static VehicleParkingChargeCompute getParkingChargeComputeFactory(VT type) {
        VehicleParkingChargeCompute vpc = cache.get(type);
        if(vpc != null) return vpc;
        vpc = switch (type) {
            case TWO -> new TwoWParkingChargeCompute(new PerMinutePrice());
            case FOUR -> new FourWParkingChargeCompute(new PerHourPrice());
        };
        cache.put(type, vpc);
        return vpc;
    }
}
