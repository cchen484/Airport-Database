package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

import org.apache.commons.dbcp2.BasicDataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CLASS NAME: DatabaseConnectionManager
 * BEHAVIOR: Manage connections to a database through JDBC and connection pooling
 */
public class DatabaseConnectionManager {
    private static final Logger loggerDBCM = LogManager.getLogger(DatabaseConnectionManager.class);

    //KEYS FOR DATABASE PROPERTIES FILE
    private static String DB_URL;
    private static String DB_UNAME;
    private static String DB_PW;
    private static boolean GENERATED = false;
    private static BasicDataSource database;

    //Generate database connection manager built on BasicDataSource
    public static void generateDBCM(){
        if(!GENERATED) {
            loadProperties();
            initializeDatabase();
            GENERATED = true;
        } else {
            loggerDBCM.info("A database connection manager has already been generated.");
        }
    }

    //Load database properties from properties file
    private static void loadProperties() {
        Properties dbProp = new Properties();

        try(InputStream input = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream("database.properties")) {
            if(input == null) {
                loggerDBCM.error("No properties included properties file.");
            } else {
                dbProp.load(input);

                DB_URL = dbProp.getProperty("database.url");
                DB_UNAME = dbProp.getProperty("database.username");
                DB_PW = dbProp.getProperty("database.password");
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
            loggerDBCM.error("There was an IOException with reading the resource");
        }
    }

    //Initialize database with properties from properties file
    private static void initializeDatabase() {
        database = new BasicDataSource();

        database.setUrl(DB_URL);
        database.setUsername(DB_UNAME);
        database.setPassword(DB_PW);

        //Set min and max number of idle connections in connection pool
        database.setMinIdle(5);
        database.setMaxIdle(10);
        database.setMaxOpenPreparedStatements(100);

    }

    //Get connection to access database
    public static Connection getConnection() throws SQLException {
        Connection conn;
        if(GENERATED) {
            conn = database.getConnection();
        } else {
            loggerDBCM.info("Connection pool is not yet generated.");
            conn = null;
        }
        return conn;
    }

    //Close connection to database
    public static void closeConnection(Connection conn) throws SQLException {
        try {
            if(GENERATED && conn != null) {
                conn.close();
            } else {
                loggerDBCM.info("Connection pool is not yet generated.");
            }
        } catch(SQLException se) {
            loggerDBCM.error("Error closing connection to database");
            se.printStackTrace();
        }
    }

    //Shut down database
    public static void shutdown() {
        try{
            database.close();
        } catch(SQLException se) {
            loggerDBCM.error("Error shutting down database.");
            se.printStackTrace();
        }

    }


}
