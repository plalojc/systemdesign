package plal.parkinglot.com.strategy;

import plal.parkinglot.com.model.Ticket;

public class PerMinutePrice implements PriceStrategy{
    @Override
    public double compute(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        long totalTimeInMilli = endTime - ticket.getEntryTime();
        long totalTimeMin = totalTimeInMilli/(1000 * 60);
        int perMinCharge = 2;
        return totalTimeMin * perMinCharge;
    }
}
