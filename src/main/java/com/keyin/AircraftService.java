package com.keyin;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AircraftService {

    public void listAirportsForAircraft(int aircraftId) {
        try {
            URL url = new URL("http://localhost:8080/aircraft/" + aircraftId + "/airports");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    String inline = sc.nextLine();
                    System.out.println(inline);
                }
                sc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

