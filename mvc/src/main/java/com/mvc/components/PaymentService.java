package com.mvc.components;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface PaymentService {

    @Retryable(recover = "recover", retryFor = RuntimeException.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
    void fluxPayments();

    @Recover
    void recover(RuntimeException e);
}
