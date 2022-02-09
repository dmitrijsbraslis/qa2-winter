package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Weather;
import model.WeatherResponse;
import requesters.WeatherRequester;

import java.util.Map;

import static java.lang.Long.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city id is {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong Lon!");
        assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong Lat!");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);
        assertEquals(parseLong(params.get("id")), weather.getId(), "Wrong Weather ID!");
        assertEquals(params.get("main"), weather.getMain(), "Wrong Weather Main!");
        assertEquals(params.get("description"), weather.getDescription(), "Wrong Weather Description!");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong Weather Icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        assertEquals(base, response.getBase(), "Wrong Base!");
    }
}
