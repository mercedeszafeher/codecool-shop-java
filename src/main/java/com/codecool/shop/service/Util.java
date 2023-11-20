package com.codecool.shop.service;

import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public class Util {

    public static BigDecimal getItemsPrice(Map<Product, Integer> cart) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Product, Integer> product : cart.entrySet()) {
            BigDecimal price = product.getKey().getPriceWithoutCurrency();
            BigDecimal amount = new BigDecimal(product.getValue());
            totalPrice = totalPrice.add(price.multiply(amount));
        }
        return totalPrice;
    }

}
