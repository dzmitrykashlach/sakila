package com.dzmitrykashlach.sakila.components;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Payment(
        @Id
        @Column(value = "payment_id") int id,
        @Column(value = "customer_id") int customerId,
        @Column(value = "staff_id") int staffId,
        @Column(value = "rental_id") int rentalId,
        @Column int amount
) {}
