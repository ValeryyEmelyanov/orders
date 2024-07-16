package com.springlessons.orders.service;

import com.springlessons.orders.model.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TraderService {
    private final WebClient webClient;

    @Autowired
    public TraderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<Trader> getTrader(int traderId) {
        return webClient.get()
                .uri("http://localhost:8081/api/v1/traders/{id}", traderId)
                .retrieve()
                .bodyToMono(Trader.class)
                .onErrorReturn(new Trader()); // Возвращаем пустой объект в случае ошибки
    }
}
