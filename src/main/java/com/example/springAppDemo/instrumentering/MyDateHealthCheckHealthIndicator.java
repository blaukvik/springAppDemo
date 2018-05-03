package com.example.springAppDemo.instrumentering;

/**
 * Created by bla on 19/04/2018.
 */
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.util.Date;

@Component
public class MyDateHealthCheckHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        int errorCode = check(); // perform some specific health check

        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {

        Date d = new Date();

        if (d.getTime() % 2 == 0)
            return 0;
        else
            return 3;

    }

}
