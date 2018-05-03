package com.example.springAppDemo.instrumentering;

import com.example.springAppDemo.db.StudentRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by bla on 19/04/2018.
 * Scope ....så er det omtrent som service
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyComponent {

        private final Counter counter;

        @Autowired
        StudentRepository studentRepository;

        public MyComponent(MeterRegistry registry) {
            this.counter = registry.counter("received.messages");
        }

        public void handleMessage(String message) {
            this.counter.increment();
        }

}
