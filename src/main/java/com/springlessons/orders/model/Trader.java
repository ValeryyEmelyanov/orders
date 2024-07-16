package com.springlessons.orders.model;

import lombok.Data;
@Data
public class Trader {
    private String name;
    private String inn;
    private String phone;

    public Trader() {}

    public Trader(String name, String inn, String phone) {
        this.name = name;
        this.inn = inn;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
