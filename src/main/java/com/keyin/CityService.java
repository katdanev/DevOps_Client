package com.keyin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CityService {
    public void listAirportsInCity(int cityIndex) {
        try {
            URL url = new URL("http://localhost:8080/city/" + cityIndex + "/airports");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Airports in city with index " + cityIndex + ":");
            System.out.println(response.toString());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
