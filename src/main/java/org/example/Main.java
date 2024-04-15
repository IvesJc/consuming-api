package org.example;

import org.example.services.WeatherApiService;

import java.io.IOException;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        var response = WeatherApiService.getWeatherJsonByCity("new%20york");
        System.out.println(response);
    }
}