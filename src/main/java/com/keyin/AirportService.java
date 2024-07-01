package com.keyin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.keyin.Airport;

public class AirportService {

    public AirportService() {

    }

    public Airport getAirportById(int airportId) {
        try {
            URL url = new URL("http://localhost:8080/airports/" + airportId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Airport airport = new Airport();


            return airport;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateAirport(Airport airport) {
        try {
            URL url = new URL("http://localhost:8080/airports/" + airport.getId());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);


            int responseCode = conn.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
