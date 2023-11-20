package com.codecool.shop.content;

public enum CategoryContent {
    CARDS("Cards"),
    ACCESSORIES("Accessories"),
    MENTORING("Magic mentoring");


    private final String name;

    CategoryContent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
