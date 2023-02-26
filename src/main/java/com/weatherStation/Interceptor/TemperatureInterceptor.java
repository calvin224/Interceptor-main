package com.weatherStation.Interceptor;

public class TemperatureInterceptor implements Interceptor {
    public void intercept(Context context) {
        float temperature = context.getTemperature();
        context.setTemperature(temperature);
        System.out.println("Temperature intercepted: " + context.getTemperature());
    }
}
