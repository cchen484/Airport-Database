package Models;

public class Airport {
    private long airportID;
    private String stateInitials;
    private String city;
    private String airportFAA;

    public Airport(long airportID, String stateInitials, String city, String airportFAA) {
        this.airportID = airportID;
        this.stateInitials = stateInitials;
        this.city = city;
        this.airportFAA = airportFAA;
    }

    public long getAirportID() {
        return this.airportID;
    }

    public void setAirportID(int newID) {
        this.airportID = newID;
    }

    public String getStateInitials() {
        return this.stateInitials;
    }

    public void setStateInitials(String newStateInitial) {
        this.stateInitials = newStateInitial;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    public String getAirportFAA() { return this.airportFAA; }
    public void setAirportFAA(String newAirportFAA) {
        this.airportFAA = newAirportFAA;
    }

}
