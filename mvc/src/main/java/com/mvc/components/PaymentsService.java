package com.mvc.components;


import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
@Slf4j
public class PaymentsService {

    HttpClient httpClient;

    PaymentsService(){
            httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    @Retryable(retryFor = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
    void fluxPayments(){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
//                .uri(URI.create("http://localhost:8080/flux/ui/payments"))
                .uri(URI.create("http://google.com"))
                .setHeader("User-Agent", "Java 11 HttpClient") // add request header
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }


    }
}
