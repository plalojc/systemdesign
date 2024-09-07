package plal.parkinglot.com.strategy;

import plal.parkinglot.com.model.Ticket;

public interface PriceStrategy {
    default double compute(Ticket ticket) {
        return 100;
    }
}
