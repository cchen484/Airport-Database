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
    private static String DB_URL;
    private static String DB_UNAME;
    private static String DB_PW;

    private static boolean GENERATED = false;
    private static BasicDataSource database;

    //Generate Connection Pool built on BasicDataSource
    public static void generateConnectionPool(){

        if(!GENERATED) {
            ConnectionPool.loadProperties();
            ConnectionPool.initializeDatabase();
            GENERATED = true; 
        } else {
            loggerJDBC.info("A connection pool has already been generated.");
        }

    }

    private static void loadProperties() {
        Properties dbProp = new Properties();

        try(InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("database.properties")) {
            if(input == null) {
                loggerJDBC.error("No properties included properties file.");
            } else {
                dbProp.load(input);

                DB_URL = dbProp.getProperty("database.url");
                DB_UNAME = dbProp.getProperty("database.username");
                DB_PW = dbProp.getProperty("database.password");

            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
            loggerJDBC.error("There was an IOException with reading the resource");
        }
    }

    //Initialize database with properties from properties file
    private static void initializeDatabase() {
        database = new BasicDataSource();

        database.setUrl(DB_URL);
        database.setUsername(DB_UNAME);
        database.setPassword(DB_PW);

        database.setMinIdle(5);
        database.setMaxIdle(10);
        database.setMaxOpenPreparedStatements(100);

    }


    public static Connection getConnection() throws SQLException {
        Connection conn;
        if(GENERATED) {
            conn = database.getConnection();
        } else {
            loggerJDBC.info("Connection pool is not yet generated.");
            conn = null;
        }
        return conn;
    }

    public static void releaseConnection(Connection conn) {

    }

    public static void closeConnection(Connection conn) throws SQLException {
        try {
            if(GENERATED && conn != null) {
                conn.close();
            } else {
                loggerJDBC.info("Connection pool is not yet generated.");
            }
        } catch(SQLException se) {
            se.printStackTrace();
            loggerJDBC.error("Error closing connection to database");
        }

    }


}
