package com.codecool.shop.content;

import java.math.BigDecimal;

public enum ProductContent {

    GUILLERMO(
            "EL MAGICO"
            , new BigDecimal("1000.99")
            , "EUR"
            , "A mythical creature has arisen in the realm of object-oriented programming, wielding the power of streams."
            , "Cards"
            , "Codecool Originals"
            , "guillermo_mtg_card"
    ),

    EL_MAD(
            "EL MAD"
            , new BigDecimal("1000.99")
            , "EUR"
            , "An Artifact of legend, lost to the ages with powers beyond comprehension."
            , "Cards"
            , "Codecool Originals"
            , "emad_mtg_card"
    ),

    EL_MARK(
            "EL MARK"
            , new BigDecimal("1000.99")
            , "EUR"
            , "One of the most powerful instants ever to be printed."
            , "Cards"
            , "Codecool Originals"
            , "mark_mtg_card"
    ),

    THE_MARTIN(
            "THE MARTIN"
            , new BigDecimal("1000.99")
            , "EUR"
            , "The card if you want to build up a strong creature"
            , "Cards"
            , "Codecool Originals"
            , "martin_mtg_card"
    ),

    ALI_THE_REZA(
            "ALI THE REZA"
            ,new BigDecimal("1000.99")
            ,"EUR"
            ,"Mandatory if many fetches are about to be happening"
            ,"Cards"
            ,"Codecool Originals"
            ,"alireza_mtg_card"
    ),

    DECKBOX(
            "Codecool Deckbox"
            ,new BigDecimal("100")
            ,"EUR"
            ,"You need something stylish and safe to store your precious Magic Cards"
            ,"Accessories"
            ,"China quality products"
            ,"deckbox"
    ),

    MAGIC_MENTORING(
            "1 Hour MTG Mentoring"
            ,new BigDecimal("100")
            ,"EUR"
            ,"Doesn't matter if you are new or just want to step up your game"
            ,"Magic mentoring"
            ,"Codecool Services"
            ,"mentoring"
    ),

    SLEEVES(
            "Card Sleeves"
            ,new BigDecimal("150")
            ,"EUR"
            ,"If you buy cards you need to buy sleeves!!!"
            ,"Accessories"
            ,"China quality products"
            ,"sleeves"
    );

    private final String name;
    private final BigDecimal price;
    private final String currencyString;
    private final String description;
    private final String category;
    private final String supplier;
    private final String imageName;

    ProductContent(String name, BigDecimal price, String currencyString, String description, String category, String supplier, String imageName) {
        this.name = name;
        this.price = price;
        this.currencyString = currencyString;
        this.description = description;
        this.category = category;
        this.supplier = supplier;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrencyString() {
        return currencyString;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getImageName() {
        return imageName;
    }
}
