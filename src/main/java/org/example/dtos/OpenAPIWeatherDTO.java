package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OpenAPIWeatherDTO {
    public record Clouds(int all) {}

    public record Coord(double lon, double lat) {}

    public record Main(double temp, double feels_like, double temp_min, double temp_max,
                       int pressure, int humidity, int sea_level, int grnd_level) {}

    public record Rain(@JsonProperty("1h") double _1h) {}

    public record Root(Coord coord, ArrayList<Weather> weather, String base, Main main,
                       int visibility, Wind wind, Rain rain, Clouds clouds, int dt, Sys sys,
                       int timezone, int id, String name, int cod) {}

    public record Sys(int type, int id, String country, int sunrise, int sunset) {}

    public record Weather(int id, String main, String description, String icon) {}

    public record Wind(double speed, int deg, double gust) {}

}