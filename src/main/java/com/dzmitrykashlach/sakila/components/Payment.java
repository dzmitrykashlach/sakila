package com.dzmitrykashlach.sakila.components;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @Column(value = "payment_id")
    private int id;

    @Column(value = "customer_id")
    private int customerId;

    @Column(value = "staff_id")
    private int staffId;

    @Column(value = "rental_id")
    private int rentalId;

    @Column
    private int amount;

    @Column(value = "payment_date")
    private LocalDateTime paymentDate;

    @Column(value = "last_update")
    private LocalDateTime lastUpdate;
}
