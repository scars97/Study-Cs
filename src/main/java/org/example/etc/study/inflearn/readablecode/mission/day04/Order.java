package org.example.etc.study.inflearn.readablecode.mission.day04;

import java.util.List;

public class Order {

    private final List<String> items;
    private final Long totalPrice;
    private final Customer customer;

    public Order(Customer customer, List<String> items, Long totalPrice) {
        this.customer = customer;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public boolean isMissingCustomerInfo() {
        return this.customer == null;
    }

    public boolean isEmptyItems() {
        return this.items.isEmpty();
    }

    public boolean isIncorrectTotalPrice() {
        return this.totalPrice < 0L;
    }
}
