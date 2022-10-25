package com.dzmitrykashlach.sakila;

import com.dzmitrykashlach.sakila.components.PaymentHandler;
import com.dzmitrykashlach.sakila.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SakilaConfig {
    @Autowired
    private PaymentRepository paymentRepository;

    @Bean
    RouterFunction<ServerResponse> routePayments(PaymentHandler paymentHandler) {
        return route(GET("/payments"), paymentHandler::all);
    }
}
