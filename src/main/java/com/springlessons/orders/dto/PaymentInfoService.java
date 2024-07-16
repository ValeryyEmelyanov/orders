package com.springlessons.orders.dto;

import com.springlessons.orders.model.PaymentInfo;
import com.springlessons.orders.model.Product;
import com.springlessons.orders.model.Trader;
import com.springlessons.orders.model.User;
import com.springlessons.orders.service.ProductService;
import com.springlessons.orders.service.TraderService;
import com.springlessons.orders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentInfoService {
    private final TraderService traderService;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public PaymentInfoService(TraderService traderService, UserService userService, ProductService productService) {
        this.traderService = traderService;
        this.userService = userService;
        this.productService = productService;
    }
    public Mono<PaymentInfo> getPaymentInfo(int traderId, int userId, int productId) {
        Mono<Trader> traderMono = traderService.getTrader(traderId);
        Mono<User> userMono = userService.getUser(userId);
        Mono<Product> productMono = productService.getProduct(productId);

        return Mono.zip(traderMono, userMono, productMono)
                .map(tuple -> {
                    PaymentInfo paymentInfo = new PaymentInfo();
                    paymentInfo.setTrader(tuple.getT1());
                    paymentInfo.setUser(tuple.getT2());
                    paymentInfo.setProduct(tuple.getT3());
                    return paymentInfo;
                });
    }
}



