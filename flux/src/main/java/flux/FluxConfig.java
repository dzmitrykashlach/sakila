package flux;

import flux.components.PaymentHandler;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import flux.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class FluxConfig {
    @Autowired
    private PaymentRepository paymentRepository;

    @Bean
    RouterFunction<ServerResponse> routePayments(PaymentHandler paymentHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/payments"), paymentHandler::all);
    }
}
