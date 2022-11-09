package com.mvc.components;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
public class Payment
 {
         @Id
         @GeneratedValue
         @Column(value = "payment_id")
         public int id;
         @Column(value = "customer_id")
         public int customerId;
         @Column(value = "staff_id")
         public int staffId;
         @Column(value = "rental_id")
         public int rentalId;
         @Column
         public float amount;
         @Column(value = "payment_date")
         public LocalDateTime paymentDate;
         @Column(value = "last_update")
         public LocalDateTime lastUpdate;

         public Payment(int customerId,int staffId,int rentalId,float amount,
                       LocalDateTime paymentDate){
                this.customerId=customerId;
                this.staffId=staffId;
                this.rentalId=rentalId;
                this.amount=amount;
                Objects.requireNonNull(paymentDate);
                this.lastUpdate = LocalDateTime.now();
        }

}
