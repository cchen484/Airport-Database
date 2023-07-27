package Parsers;

import Models.Flight;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.Main;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonJsonParser {
    private static final Logger loggerJackson = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        //configure object mapper to deserialize array
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        try {
            Flight[] flights = objectMapper.readValue(new File("src/main/resources/JSON/flights.json"), Flight[].class);

        } catch(IOException ie) {
            loggerJackson.error("There was an IO exception with the Object Mapper");
        }
    }

}
