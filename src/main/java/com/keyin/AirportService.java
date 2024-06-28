package com.keyin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.keyin.Airport;

public class AirportService {

    public AirportService() {
        // Конструктор
    }

    // Метод для отримання інформації про аеропорт за його ідентифікатором
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

            // Припустимо, що відповідь сервера містить JSON з інформацією про аеропорт
            // Можна реалізувати парсинг JSON і створення об'єкта Airport

            Airport airport = new Airport();
            // Заповнення даних про аеропорт (потрібно додати парсинг JSON)

            return airport;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Метод для оновлення інформації про аеропорт
    public boolean updateAirport(Airport airport) {
        try {
            URL url = new URL("http://localhost:8080/airports/" + airport.getId());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Перетворення об'єкта Airport в JSON і відправка на сервер

            // Додатковий код для відправки даних на сервер

            int responseCode = conn.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Інші методи можна реалізувати аналогічно для CRUD операцій з аеропортами
}
