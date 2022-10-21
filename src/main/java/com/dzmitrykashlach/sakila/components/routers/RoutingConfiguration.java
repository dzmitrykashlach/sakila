package com.dzmitrykashlach.sakila.components.routers;

import com.dzmitrykashlach.sakila.components.handlers.PaymentsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> getCheckList(PaymentsHandler paymentsHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/payments")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), paymentsHandler::getPayments);
    }


}