package Models;

import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Models.Interfaces.Flight;
public class FirstClassFlight implements Flight {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    protected EconomyFlight econFlight;
    private int luggageLimit;
    private int carryOnKilos;
    private int luggageAdded;

    public FirstClassFlight(EconomyFlight econFlight) {
        this.econFlight = econFlight;
        luggageLimit = econFlight.getLuggageLimit() + 2;
        carryOnKilos = econFlight.getCarryOnKilos() + 5;
        luggageAdded = econFlight.getLuggageAdded();
    }

    public boolean checkIn() {
        return econFlight.checkIn();
    }

    public void addLuggage() {
        if(luggageAdded < luggageLimit) {
            luggageAdded++;
        } else {
            LOGGER.info("Reached limit for first class luggage. You can have " +
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
