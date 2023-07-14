package DAO.Interfaces;

import Models.Airport;

import java.util.List;

public interface AirportsDAO {
    Airport create (Airport airport);
    Airport getAirportByID(long AirportID);
    List<Airport> getAllAirports();
    void insertAirport(Airport airport);
    void updateAirport(long AirportID);
    void deleteAirport(long AirportID);;
}
