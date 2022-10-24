package com.dzmitrykashlach.sakila;

import com.dzmitrykashlach.sakila.components.Payment;
import com.dzmitrykashlach.sakila.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SakilaConfig {
    @Autowired
    private PaymentRepository paymentRepository;

    @Bean
    RouterFunction<ServerResponse> getPaymentRoute() {
        return route(GET("/payments"), paymentFunction());
    }


    private HandlerFunction paymentFunction() {
        ResponseEntity<Mono<List<Payment>>> listServerResponse =
                ResponseEntity.ok().body(
                        paymentRepository.findAll().collectList()
                );

        return req -> Objects.requireNonNull(
                listServerResponse.getBody());
    }
}
