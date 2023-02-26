package com.weatherStation.Interceptor;

public class HumidityInterceptor implements Interceptor {
    public void intercept(Context context) {
        float humidity = context.getHumidity();
        context.setHumidity(humidity);
        System.out.println("Humidity intercepted: " + context.getHumidity());
    }
}
