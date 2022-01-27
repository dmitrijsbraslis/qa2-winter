package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        WeatherResponse response = requester.requestWeather(524901);

        System.out.println(response.getCoord().getLat());
    }
}
