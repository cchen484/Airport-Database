package DAO.Interfaces;

import Models.Customer;

import java.util.List;

public interface CustomerDAO{
    Customer getCustomerByID(int customerID);
    List<Customer> getAllCustomers();
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerID);;
}
