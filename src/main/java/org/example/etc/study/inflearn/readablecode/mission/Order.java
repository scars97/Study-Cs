package org.example.etc.study.inflearn.readablecode.mission;

import java.util.List;

public class Order {

    private final List<String> items;
    private final Integer totalPrice;
    private final boolean customerInfo;

    public Order(List<String> items, Integer totalPrice, boolean customerInfo) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.customerInfo = customerInfo;
    }

    public List<String> getItems() {
        return items;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public boolean hasCustomerInfo() {
        return customerInfo;
    }
}
