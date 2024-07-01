package com.keyin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PassengerService {

    public void listAircraftForPassenger(int passengerId) {
        try {
            URL url = new URL("http://localhost:8080/passenger/" + passengerId + "/aircraft");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            } else {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listAirportsForPassenger(int passengerId) {


            try {
                URL url = new URL("http://localhost:8080/passenger/" + passengerId + "/airports");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                if (responseCode != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + responseCode);
                } else {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                }
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
