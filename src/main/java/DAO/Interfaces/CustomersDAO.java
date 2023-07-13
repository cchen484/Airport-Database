package DAO.Interfaces;

import Models.Customer;

import java.util.List;

public interface CustomersDAO{
    Customer getCustomerByID(long customerID);
    List<Customer> getAllCustomers();
    void insertCustomer(Customer customer);
    void updateCustomer(long customerID);
    void deleteCustomer(long customerID);;
}
