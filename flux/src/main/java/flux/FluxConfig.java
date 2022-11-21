package flux;

import flux.components.PaymentHandler;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import flux.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

//import javax.mail.MessagingException;
//import java.util.Properties;

@Configuration
public class FluxConfig {
    @Autowired
    private PaymentRepository paymentRepository;

    @Bean
    RouterFunction<ServerResponse> routePayments(PaymentHandler paymentHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/payments"), paymentHandler::all);
    }
   /* @Bean("javaMailSender")
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.yandex.com");
        sender.setPort(465);

        sender.setUsername("dzmitry.kashlach@yandex.ru");
        sender.setPassword("kGTM4kHnA5A");

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        try {
            sender.testConnection();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return sender;
    }*/
}
