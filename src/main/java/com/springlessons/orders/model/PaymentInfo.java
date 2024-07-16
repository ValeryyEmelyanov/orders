package com.springlessons.orders.model;

import com.springlessons.orders.model.Product;
import com.springlessons.orders.model.Trader;
import com.springlessons.orders.model.User;
import lombok.Data;

@Data
public class PaymentInfo {
    private Trader trader;
    private User user;
    private Product product;

    public PaymentInfo() {}

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}