package Services;

import java.io.IOException;
import java.util.List;
import DAO.Interfaces.CustomerMapper;
import com.sun.tools.javac.Main;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Models.Customer;

import java.io.InputStream;

public class CustomerMyBatis {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static CustomerMapper customerMapper;
    private static SqlSessionFactory sessionFactory;

    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException ie) {
            logger.error("Error initializing MyBatis", ie);
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void createCustomerMyBatis() {
        try (SqlSession sqlSession = sessionFactory.openSession(true)) {
            customerMapper = sqlSession.getMapper(CustomerMapper.class);
        }
    }

    public static Customer getCustomerByID(int customerID) {
        return customerMapper.getCustomerByID(customerID);
    }

    public static List<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }

    public static void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    public static void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    public static void deleteCustomer(int customerID) {
        customerMapper.deleteCustomer(customerID);
    }

}
