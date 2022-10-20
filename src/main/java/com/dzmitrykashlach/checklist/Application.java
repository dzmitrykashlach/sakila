package com.dzmitrykashlach.checklist;

import com.dzmitrykashlach.checklist.components.Payment;
import com.dzmitrykashlach.checklist.components.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

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
	    Payment payment = paymentFlux.elementAt(30).blockOptional().get();
		log.info(payment.toString());
	}
}