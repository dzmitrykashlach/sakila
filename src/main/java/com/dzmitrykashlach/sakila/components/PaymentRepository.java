package com.dzmitrykashlach.sakila.components;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {

}
