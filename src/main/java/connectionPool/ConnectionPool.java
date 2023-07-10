package connectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

import org.apache.commons.dbcp2.BasicDataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
    private static final Logger loggerJDBC = LogManager.getLogger(ConnectionPool.class);

    //KEYS FOR DATABASE PROPERTIES FILE
    private static final String PROP_FILE = "database.properties";
    private static final String DB_URL = "database.url";
    private static final String DB_UNAME = "database.username";
    private static final String DB_PW = "database.password";

    private static boolean GENERATED = false;
    private static BasicDataSource database;

    //GENERATE CONNECTION POOL BASED ON BASICDATASOURCE
    public static void generateConnectionPool(){
        if(!GENERATED) {
            database = new BasicDataSource();
            Properties dbProp = new Properties();

            try(InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream(PROP_FILE)) {
                if(input == null) {
                    loggerJDBC.error("No properties included properties file.");
                } else {
                    dbProp.load(input);

                    //INITIALIZE DATABASE WITH PROPERTIES FROM PROPERTIES FILE
                    database.setUrl(dbProp.getProperty(DB_URL));
                    database.setUsername(dbProp.getProperty(DB_UNAME));
                    database.setPassword(dbProp.getProperty(DB_PW));

                    database.setMinIdle(5);
                    database.setMaxIdle(10);
                    database.setMaxOpenPreparedStatements(100);
                }

            } catch(IOException ioe) {
                ioe.printStackTrace();
                loggerJDBC.error("There was an IOException");
            }

        } else {
            loggerJDBC.info("Connection pool already generated.");
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection conn;
        if(GENERATED) {
            conn = database.getConnection();
        } else {
            loggerJDBC.info("Connection pool is not generated yet.");
            conn = null;
        }
        return conn;
    }
    

    public static void main(String[] args){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            loggerJDBC.error("No JDBC driver found");
        }

        Connection conn = null;
        try {
            String query = "SELECT * FROM CUSTOMERS";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                System.out.println(resultSet.getString("booking_name"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }

    }
}
