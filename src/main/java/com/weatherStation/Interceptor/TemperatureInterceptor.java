package com.weatherStation.Interceptor;

public class TemperatureInterceptor implements Interceptor {
    public void intercept(Context context) {
        System.out.println("Temperature intercepted: " + context.getTemperature());
    }
}
