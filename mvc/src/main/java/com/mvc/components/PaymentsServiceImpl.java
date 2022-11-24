package com.mvc.components;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;

@Service
public class PaymentsServiceImpl implements PaymentService{

    @Override
    public void fluxPayments(){
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/flux/ui/payments"))
                .setHeader("User-Agent", "Java 11 HttpClient") // add request header
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("We're inside catch block: "+ Arrays.toString(e.getStackTrace()));
            throw new RuntimeException();
        }
    }

    @Override
    public void recover(RuntimeException e) {
        System.out.println("We've recovered");
    }
}
