package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Models.Interfaces.Flight;

public class EconomyFlight implements Flight {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    @JsonProperty("flight_id")
    private long flightID;
    @JsonProperty("departure_time")
    private String departureTime;
    @JsonProperty("arrival_time")
    private String arrivalTime;
    @JsonProperty("departure_FAA")
    private String departureAirportFAA;
    @JsonProperty("arrival_FAA")
    private String arrivalAirportFAA;

    private final int luggageLimit = 3;
    private final int carryOnKilos = 10;
    private int luggageAdded = 0;
    private boolean checkedIn = false;

    public EconomyFlight(long flightID, String departureTime, String arrivalTime,
                         String departureAirportFAA, String arrivalAirportFAA) {
        this.flightID = flightID;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirportFAA = departureAirportFAA;
        this.arrivalAirportFAA = arrivalAirportFAA;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightID=" + flightID +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureAirportFAA='" + departureAirportFAA + '\'' +
                ", arrivalAirportFAA='" + arrivalAirportFAA + '\'' +
                '}';
    }

    //GETTERS and SETTERS for decorators
    public int getLuggageLimit() {
        return luggageLimit;
    }

    public int getCarryOnKilos() {
        return carryOnKilos;
    }

    public int getLuggageAdded() {
        return luggageAdded;
    }

    public void setLuggageAdded(int luggageAdded) {
        this.luggageAdded = luggageAdded;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }


    //GETTERS and SETTERS for instance properties
    public long getFlightID() {
        return this.flightID;
    }

    public void setFlightID(long newID) {
        this.flightID = newID;
    }

    public String getDeparture() {
        return this.departureAirportFAA + ": " + this.departureTime;
    }
    public void setDeparture(String newFAA, String newTime) {
        this.departureAirportFAA = newFAA;
        this.departureTime = newTime;
    }
    public String getArrival() {
        return this.arrivalAirportFAA + ": " + this.arrivalTime;
    }
    public void setArrival(String newFAA, String newTime) {
        this.arrivalAirportFAA = newFAA;
        this.arrivalTime = newTime;
    }

    public boolean checkIn() {
        if(!checkedIn) {
            checkedIn = true;
            LOGGER.info("You are now checked in for your flight.");
        } else {
            LOGGER.info("You are already checked in for your flight.");
        }
        return checkedIn;
    }

    public void addLuggage() {
        if(luggageAdded < luggageLimit) {
            luggageAdded++;
        } else {
            LOGGER.info("Reached limit for economy luggage. You can have " +
                    luggageLimit + "pieces of luggage.");
        }
    }

    public void addCarryOn(int weight) {
        if(weight < carryOnKilos) {
            LOGGER.info("Your carry-on meets the weight limit.");
        } else {
            LOGGER.info("Reached limit for carry on weight. You can have 10 kilos for your carry on.");
        }
    }

}
