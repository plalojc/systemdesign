package plal.parkinglot.com.model;

public class Ticket {
    private int ticketNo;
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingNo;

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(ParkingSlot parkingNo) {
        this.parkingNo = parkingNo;
    }
}
