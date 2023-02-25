package com.weatherStation.Junit;

import com.weatherStation.CurrentConditionsDisplay;
import com.weatherStation.Interceptor.HumidityInterceptor;
import com.weatherStation.Interceptor.PressureInterceptor;
import com.weatherStation.Interceptor.TemperatureInterceptor;
import com.weatherStation.WeatherData;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.testng.AssertJUnit.assertEquals;

public class WeatherStationTest {
    @Test
    public void testWeatherStation() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        TemperatureInterceptor temperatureInterceptor = new TemperatureInterceptor();
        HumidityInterceptor humidityInterceptor = new HumidityInterceptor();
        PressureInterceptor  pressureInterceptor = new PressureInterceptor();
        weatherData.addInterceptor(temperatureInterceptor);
        weatherData.addInterceptor(humidityInterceptor);
        weatherData.addInterceptor(pressureInterceptor);
        weatherData.registerObserver(currentDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);

        String expectedOutput =
                ("Temperature intercepted: 80.0\r\n" +
                        "Humidity intercepted: 65.0\r\n" +
                        "Pressure intercepted: 30.4\r\n" +
                        "Current conditions: 80.0F degrees and 65.0% humidity\r\n" +
                        "Current conditions: 80.0F degrees and 65.0% humidity");
        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }
}



