package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dtos.OpenAPIWeatherDTO;
import org.example.utils.HttpClientUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

public class WeatherApiService {

    public static final String API_KEY = "cb5abcabf021d0fa40c64b46fd1dcea8";
    public static final String BASE_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=";

    public static OpenAPIWeatherDTO getWeatherByCity(String city) throws URISyntaxException, IOException,
            InterruptedException {
        String url = BASE_URL + city + "&appid=" + API_KEY;
        String  response = HttpClientUtil.sendGet(url);
        ObjectMapper om = new ObjectMapper();
        return om.readValue(response, OpenAPIWeatherDTO.class);
    }

    public static String getWeatherJsonByCity(String city) throws URISyntaxException, IOException,
            InterruptedException {
        String url = BASE_URL + city + "&appid=" + API_KEY;
        return HttpClientUtil.sendGet(url);
    }

    public static CompletableFuture<OpenAPIWeatherDTO.Root>  getWeatherByCityAsync(String city) throws URISyntaxException {
        var url = BASE_URL + city + "&units=metric&appid=" + API_KEY;
        return HttpClientUtil.sendGetAsync(url).thenApply(response -> {
            try {
                ObjectMapper om = new ObjectMapper();
                return om.readValue(response, OpenAPIWeatherDTO.Root.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
