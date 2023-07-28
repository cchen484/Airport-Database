package Services.JDBC;

import DAO.DatabaseConnectionManager;
import DAO.Interfaces.CustomerDAO;
import Models.Customer;
import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOJDBC implements CustomerDAO{
    private static final Logger loggerCDAO = LogManager.getLogger(Main.class);

    public CustomerDAOJDBC() { }

    @Override
    public Customer getCustomerByID(int customerID) {
        Customer customer = null;

        String query = "SELECT * FROM Customers WHERE id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer= new Customer(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
            }
        } catch (SQLException se) {
            loggerCDAO.error("Cannot get connection to database.");
            se.printStackTrace();
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        String query = "SELECT * FROM Customers";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            ps = connection.prepareStatement("SELECT * FROM Customers");
            rs = ps.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("age"), rs.getString("email")));
            }
        } catch (SQLException se) {
            loggerCDAO.error("Cannot get connection to database.");
            se.printStackTrace();
        }

        return customers;
    }

    @Override
    public void insertCustomer(Customer customer){
        String query = "INSERT INTO Customers (first_name, last_name, age) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();

        } catch (SQLException se) {
            loggerCDAO.error("Cannot get connection to database.");
            se.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer){
        String query = "UPDATE Customers " +
                        "SET first_name=?, " +
                        "last_name=?, " +
                        "age=?, " +
                        "WHERE id=?";
        PreparedStatement ps = null;

        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getAge());
            ps.setInt(4, customer.getCustomerID());
            ps.executeUpdate();

        } catch (SQLException se) {
            loggerCDAO.error("Cannot get connection to database.");
            se.printStackTrace();
        }
    }
    @Override
    public void deleteCustomer(int customerID) {
        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Customers WHERE id = ?");
            ps.setInt(1, customerID);
            ps.executeUpdate();
        } catch (SQLException se) {
            loggerCDAO.error("Cannot get connection to database.");
            se.printStackTrace();
        }
    }

}
