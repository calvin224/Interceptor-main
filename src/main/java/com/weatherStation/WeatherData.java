package com.weatherStation;


import com.weatherStation.Interceptor.Interceptor;
import com.weatherStation.Interceptor.Context;
import java.util.*;


public class WeatherData implements Subject {
	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	private List<Interceptor> interceptors;
	private Dispatcher dispatcher;

	public WeatherData() {
		observers = new ArrayList<>();
		interceptors = new ArrayList<>();
		dispatcher = new Dispatcher();
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		Context context = new Context(temperature, humidity, pressure);
		dispatcher.dispatch(context, interceptors);
		this.temperature = context.getTemperature();
		this.humidity = context.getHumidity();
		this.pressure = context.getPressure();
		measurementsChanged();
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void addInterceptor(Interceptor interceptor) {
		interceptors.add(interceptor);
	}

	private class Dispatcher {
		void dispatch(Context context, List<Interceptor> interceptors) {
			for (Interceptor interceptor : interceptors) {
				interceptor.intercept(context);
			}
		}
	}
}

