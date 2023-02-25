package com.weatherStation.Interceptor;

public class PressureInterceptor implements Interceptor {
    public void intercept(Context context) {
        System.out.println("Pressure intercepted: " + context.getPressure());
    }
}
