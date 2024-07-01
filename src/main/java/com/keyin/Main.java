package com.keyin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityService();
        PassengerService passengerService = new PassengerService();
        AircraftService aircraftService = new AircraftService();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. List all airports in a city");
            System.out.println("2. List all aircraft a passenger has traveled on");
            System.out.println("3. List all airports an aircraft can take off from and land at");
            System.out.println("4. List all airports a passenger has used");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter city index: ");
                    int cityIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    cityService.listAirportsInCity(cityIndex);
                    break;
                case 2:
                    System.out.print("Enter passenger ID: ");
                    int passengerId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    passengerService.listAircraftForPassenger(passengerId);
                    break;
                case 3:
                    System.out.print("Enter aircraft ID: ");
                    int aircraftId = scanner.nextInt();
                    scanner.nextLine();
                    aircraftService.listAirportsForAircraft(aircraftId);
                    break;
                case 4:
                    System.out.print("Enter passenger ID: ");
                    passengerId = scanner.nextInt();
                    scanner.nextLine();
                    passengerService.listAirportsForPassenger(passengerId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
