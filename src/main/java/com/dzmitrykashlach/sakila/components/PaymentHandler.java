package com.dzmitrykashlach.sakila.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PaymentHandler {

    @Autowired
    private PaymentRepository paymentRepository;

    public Mono<ServerResponse> all(ServerRequest serverRequest){
        Flux<Payment> payments = this.paymentRepository.findAll();
        return ServerResponse.ok().body(paymentRepository.findAll(), Payment.class);
    }
}
