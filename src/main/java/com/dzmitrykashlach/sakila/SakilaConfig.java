package com.dzmitrykashlach.sakila;

import com.dzmitrykashlach.sakila.components.Payment;
import com.dzmitrykashlach.sakila.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SakilaConfig {
    @Autowired
    private PaymentRepository paymentRepository;

    @Bean
    RouterFunction<ServerResponse> getPaymentRoute() {
        return route(GET("/payments"),
                req -> ServerResponse.ok().body(BodyInserters.fromProducer(
                        paymentRepository.findAll(), Payment.class))
        );
    }

}
