package plal.parkinglot.com.strategy;

import plal.parkinglot.com.model.Ticket;

public abstract class VehicleParkingChargeCompute {
    private PriceStrategy ps;

    public VehicleParkingChargeCompute(PriceStrategy ps){
        this.ps = ps;
    }

    public void setPriceStrategy(PriceStrategy ps) {
        if(ps != null) {
            this.ps = ps;
        }
    }

    public double parkingChargeCompute(Ticket ticket) {
        return  ps.compute(ticket);
    }
}
