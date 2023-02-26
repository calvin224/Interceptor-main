package com.weatherStation.Interceptor;

public class PressureInterceptor implements Interceptor {
    public void intercept(Context context) {
        float pressure = context.getPressure();
        context.setPressure(pressure);
        System.out.println("Pressure intercepted: " + context.getPressure());
    }
}
