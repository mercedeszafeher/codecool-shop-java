package com.codecool.shop.model;

import java.util.Map;

public class Order {

    private static Order instance = null;

    private Map<Product, Integer> products;

    private Order() {}

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void setOrderProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int itemCount() {
        return products.values().stream().mapToInt(Integer::intValue).sum();
    }
}
