package com.codecool.shop.content;

public enum SupplierContent {
    CHINA("China quality products"),
    CODECOOL("Codecool Originals"),
    SERVICE("Codecool Services");

    private final String name;

    SupplierContent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
