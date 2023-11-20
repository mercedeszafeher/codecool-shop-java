package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private static Cart instance = null;
    private Map<Product, Integer> products;

    private Cart() {
        this.products = new HashMap<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }



    public void add(Product newProduct) {
        if (!products.containsKey(newProduct)) {
            products.put(newProduct, 1);
        } else {
            products.put(newProduct, products.get(newProduct) + 1);
        }
    }

    public void remove(Product productToRemove) {
        if (products.containsKey(productToRemove)) {
            products.put(productToRemove, products.get(productToRemove) - 1);
            if (products.get(productToRemove) < 1) {
                products.remove(productToRemove);
            }
        }
    }

    public int itemCount() {
        return products.values().stream().mapToInt(Integer::intValue).sum();
    }

}
