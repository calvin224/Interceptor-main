package com.weatherStation;

import com.weatherStation.Interceptor.HumidityInterceptor;
import com.weatherStation.Interceptor.PressureInterceptor;
import com.weatherStation.Interceptor.TemperatureInterceptor;

import java.util.*;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		TemperatureInterceptor temperatureInterceptor = new TemperatureInterceptor();
		HumidityInterceptor humidityInterceptor = new HumidityInterceptor();
		PressureInterceptor pressureInterceptor = new PressureInterceptor();
		weatherData.addInterceptor(pressureInterceptor);
		weatherData.addInterceptor(temperatureInterceptor);
		weatherData.addInterceptor(humidityInterceptor);

		weatherData.registerObserver(currentDisplay);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
