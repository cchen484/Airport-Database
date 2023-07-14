package DAO.Services;

import Models.Customer;
import DAO.Interfaces.DAO;
import DAO.Interfaces.CustomerDAO;

import java.util.List;

public class CustomerService implements DAO<Customer> {
    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer get(int customerID) {
        return customerDAO.getCustomerByID(customerID);
    }

    public List<Customer> getAll() {
        return customerDAO.getAllCustomers();
    }
    public void insert(Customer customer) {
        customerDAO.insertCustomer(customer);
    }
    public void update(Customer customer) {
        customerDAO.updateCustomer(customer);
    }
    public void delete(int customerID){
        customerDAO.deleteCustomer(customerID);
    }
}
