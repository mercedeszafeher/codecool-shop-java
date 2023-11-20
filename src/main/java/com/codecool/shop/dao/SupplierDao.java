package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

public interface SupplierDao {

    void add(Supplier supplier);
    Supplier find(int id);
    Supplier findByName(String supplierName);
    void remove(int id);

    List<Supplier> getAll();
}
