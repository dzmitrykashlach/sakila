package com.dzmitrykashlach.sakila;

import com.dzmitrykashlach.sakila.components.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}