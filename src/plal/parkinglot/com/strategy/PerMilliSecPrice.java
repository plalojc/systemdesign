package plal.parkinglot.com.strategy;

import plal.parkinglot.com.model.Ticket;

public class PerMilliSecPrice implements PriceStrategy{
    @Override
    public double compute(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        long totalTimeInMilli = endTime - ticket.getEntryTime();

        return totalTimeInMilli * 0.001;
    }
}
