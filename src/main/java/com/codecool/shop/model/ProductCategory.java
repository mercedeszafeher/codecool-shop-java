package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory extends BaseModel {
    //private String department;
    private List<Product> products;

    public ProductCategory(String name) {
        super(name);
        //this.department = department;
        this.products = new ArrayList<>();
    }

//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return String.format(
                "id: %1$d," + "\nname: %2$s, ",
                this.id,
                this.name);
    }
}