package flux;

import flux.components.Payment;
import flux.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RouterFunction<ServerResponse> routerFunction;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Payment> paymentList = paymentRepository.findAll().collectList().block();
        paymentList.get(0);
    }
}