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
            case VT.TWO -> new TwoWPM(60);
            case VT.FOUR -> new FourWPM(100);
        };
        cache.put(type, pm);
        return pm;
    }
}
