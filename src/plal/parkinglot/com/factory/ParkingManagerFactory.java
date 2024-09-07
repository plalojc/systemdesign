package plal.parkinglot.com.factory;

import plal.parkinglot.com.manager.FourWPM;
import plal.parkinglot.com.manager.ParkingManager;
import plal.parkinglot.com.manager.TwoWPM;
import plal.parkinglot.com.util.VT;

import java.util.HashMap;
import java.util.Map;

public class ParkingManagerFactory {
    private ParkingManagerFactory() {

    }

    private static Map<VT, ParkingManager> cache= new HashMap<>();

    public static ParkingManager getParkingManager(VT type){
        ParkingManager pm = cache.get(type);
        if(pm != null) return pm;

        pm = switch (type) {
            case TWO -> new TwoWPM(6);
            case FOUR -> new FourWPM(10);
        };
        cache.put(type, pm);
        return pm;
    }
}
