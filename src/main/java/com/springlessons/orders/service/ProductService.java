package com.springlessons.orders.service;

import com.springlessons.orders.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<Product> getProduct(int productId) {
        return webClient.get()
                .uri("http://localhost:8081/api/v1/catalog/product/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class)
                .onErrorReturn(new Product()); // Возвращаем пустой объект в случае ошибки
    }
}