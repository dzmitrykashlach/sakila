package com.mvc;

import com.mvc.components.Payment;
import com.mvc.components.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication(scanBasePackages = {"com.mvc.components"})
@ComponentScan({"com.mvc.components"})
@EnableRetry
public class Application implements CommandLineRunner {


    @Autowired
    PaymentRepository paymentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        // SELECT * from payment p  order by payment_id  DESC ;
        long paymentSize = paymentRepository.findAll().spliterator().getExactSizeIfKnown();
        List<Payment> payments = new ArrayList<>();
        while (paymentSize < 65528) {
            Payment payment = new Payment(599, 1, 514, random.nextFloat(),
                    LocalDateTime.of(2022, Month.APRIL, 16, 12, 34)
            );
            payments.add(payment);
            paymentSize++;
        }
        System.out.println(System.currentTimeMillis());
        paymentRepository.saveAll(payments);
        System.out.println(System.currentTimeMillis());
    }
}