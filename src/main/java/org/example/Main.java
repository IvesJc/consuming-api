package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.WeatherApiService;
import org.example.utils.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        var response = WeatherApiService.getWeatherByCityAsync("new%20york").join();

        try {
            FileUtil.write("previsao_"+ LocalDateTime.now() +".json",
                    new ObjectMapper().writeValueAsString(response));
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}