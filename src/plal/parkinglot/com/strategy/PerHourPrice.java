package plal.parkinglot.com.strategy;

import plal.parkinglot.com.model.Ticket;

public class PerHourPrice implements PriceStrategy{
    @Override
    public double compute(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        long totalTimeInMilli = endTime - ticket.getEntryTime();
        long totalTimeH = totalTimeInMilli/(1000 * 60 *60);
        int perMinCharge = 40;
        return totalTimeH * perMinCharge;
    }
}
