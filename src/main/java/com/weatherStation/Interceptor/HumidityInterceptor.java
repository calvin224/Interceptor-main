package com.weatherStation.Interceptor;

public class HumidityInterceptor implements Interceptor {
    public void intercept(Context context) {
        System.out.println("Humidity intercepted: " + context.getHumidity());
    }
}
