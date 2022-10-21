package com.dzmitrykashlach.sakila;

import com.dzmitrykashlach.sakila.components.Payment;
import com.dzmitrykashlach.sakila.components.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
	@Autowired
	private PaymentRepository paymentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux<Payment> paymentFlux = this.paymentRepository.findAll();
		List<Payment> list = paymentFlux.collectList().block();
		System.out.println(list.size());
	}
}