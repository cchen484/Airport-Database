package DAO.Interfaces;

import Models.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerMapper {
    @Select("SELECT * FROM Customers")
    Customer getCustomerByID(int customerID);
    @Select("SELECT * FROM Customers WHERE customer_id = #{customerId}")
    List<Customer> getAllCustomers();
    @Insert("INSERT INTO Customers (first_name, last_name, age, email) " +
            "VALUES (#{firstName}, #{lastName}, #{age}, #{email})")
    void insertCustomer(Customer customer);
    @Update("UPDATE Customers SET customer_id = #{customerId}, first_name = #{firstName}, last_name = #{lastName}, " +
            "age = #{age}, email = #{email} WHERE customer_id = #{customerId}")
    void updateCustomer(Customer customer);
    @Delete("DELETE FROM Customers WHERE customer_id = #{customerId}")
    void deleteCustomer(int customerID);;

}
