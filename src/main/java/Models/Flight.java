package Models;
import java.sql.Date;

public class Flight {
    private long flightID;
    private Date departureTime;
    private Date arrivalTime;
    private String departureAirportFAA;
    private String arrivalAirportFAA;

    public Flight(long flightID, Date departureTime, Date arrivalTime,
                  String departureAirportFAA, String arrivalAirportFAA) {
        this.flightID = flightID;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirportFAA = departureAirportFAA;
        this.arrivalAirportFAA = arrivalAirportFAA;
    }

    public long getFlightID() {
        return this.flightID;
    }

    public void setFlightID(long newID) {
        this.flightID = newID;
    }

    public String getDeparture() {
        return this.departureAirportFAA + ": " + this.departureTime.toString();
    }
    public void setDeparture(String newFAA, Date newTime) {
        this.departureAirportFAA = newFAA;
        this.departureTime = newTime;
    }
    public String getArrival() {
        return this.arrivalAirportFAA + ": " + this.arrivalTime.toString();
    }
    public void setArrival(String newFAA, Date newTime) {
        this.arrivalAirportFAA = newFAA;
        this.arrivalTime = newTime;
    }

}
