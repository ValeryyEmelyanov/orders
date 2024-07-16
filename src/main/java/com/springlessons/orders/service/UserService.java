package com.springlessons.orders.service;

import com.springlessons.orders.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final WebClient webClient;

    @Autowired
    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<User> getUser(int userId) {
        return webClient.get()
                .uri("http://localhost:8081/api/v1/user/{id}", userId)
                .retrieve()
                .bodyToMono(User.class)
                .onErrorReturn(new User()); // Возвращаем пустой объект в случае ошибки
    }
}
