package Models;

public class Booking {
    private long bookingID;
    private String firstName;
    private String lastName;
    private String email;
    private String departureAirportFAA;
    private String arrivalAirportFAA;
    private String destinationCity;

    public Booking(long bookingID, String firstName, String lastName, String email,
                   String departureAirportFAA, String arrivalAirportFAA, String destinationCity) {
        this.bookingID = bookingID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departureAirportFAA = departureAirportFAA;
        this.arrivalAirportFAA = arrivalAirportFAA;
        this.destinationCity = destinationCity;
    }

    public long getBookingID() { return this.bookingID;}
    public void setBookingID(int newID) {
        this.bookingID = newID;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getDepartureAirport(){
        return this.departureAirportFAA;
    }
    public void setDepartureAirport(String newFAA) {
        this.departureAirportFAA = newFAA;
    }

    public String getArrivalAirport(){
        return this.arrivalAirportFAA;
    }
    public void setArrivalAirport(String newFAA) {
        this.arrivalAirportFAA = newFAA;
    }

    public String getDestinationCity(){
        return this.destinationCity;
    }
    public void setDestinationCity(String newCity) {
        this.destinationCity = newCity;
    }

}
