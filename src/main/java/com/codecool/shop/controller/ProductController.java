package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String supplier = req.getParameter("supplier");

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        Cart cart = Cart.getInstance();
        ProductService productService = new ProductService(productDataStore,productCategoryDataStore, supplierDataStore);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("categoryName", category);
        context.setVariable("supplierName", supplier);
        context.setVariable("itemsSum", cart.itemCount());
        if (category != null && !category.equals("Choose category")) {
            context.setVariable("products", productService.getProductsForCategoryByName(category));
        }
        else if (supplier != null && !supplier.equals("Choose supplier")) {
            context.setVariable("products", productService.getProductsForSupplierByName(supplier));
        }
        else {
            context.setVariable("products", productService.getAll());
        }
        context.setVariable("suppliers", supplierDataStore.getAll());
        engine.process("product/index.html", context, resp.getWriter());
    }

}