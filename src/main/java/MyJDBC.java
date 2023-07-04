import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class MyJDBC {

    private static final Logger loggerJDBC = LogManager.getLogger(MyJDBC.class);
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            loggerJDBC.error("No JDBC driver found");
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport-database", "root", "toor");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Bookings");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("booking_name"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }


    }
}
