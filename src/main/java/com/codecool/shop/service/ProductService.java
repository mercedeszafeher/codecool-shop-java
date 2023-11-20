package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;

import java.util.List;

public class ProductService{
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;

    private SupplierDao supplierDao;

    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao, SupplierDao supplierDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.supplierDao = supplierDao;
    }


    public List<Product> getProductsForCategoryByName(String categoryName) {
        var category = productCategoryDao.findByName(categoryName);
        return productDao.getBy(category);
    }

    public List<Product> getProductsForSupplierByName(String supplierName) {
        var category = supplierDao.findByName(supplierName);
        return productDao.getBy(category);
    }

    public  List<Product> getAll() {
        return productDao.getAll();
    }


}
