package com.codecool.shop.config;

import com.codecool.shop.content.CategoryContent;
import com.codecool.shop.content.ProductContent;
import com.codecool.shop.content.SupplierContent;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Objects;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        // Enums
        for (CategoryContent value : CategoryContent.values()) {
            productCategoryDataStore.add(new ProductCategory(value.getName()));
        }

        for (SupplierContent value : SupplierContent.values()) {
            supplierDataStore.add(new Supplier(value.getName()));
        }

        ProductCategory productCategory = null;
        Supplier productSupplier = null;
        for (ProductContent value : ProductContent.values()) {
            for (ProductCategory category : productCategoryDataStore.getAll()) {
                if (Objects.equals(value.getCategory(), category.getName())) {
                    productCategory = category;
                }
            }
            for (Supplier supplier : supplierDataStore.getAll()) {
                if (Objects.equals(value.getSupplier(), supplier.getName())) {
                    productSupplier = supplier;
                }
            }
            productDataStore.add(new Product(value.getName(), value.getPrice(), value.getCurrencyString(), value.getDescription(), productCategory, productSupplier, value.getImageName()));
        }
    }

}
