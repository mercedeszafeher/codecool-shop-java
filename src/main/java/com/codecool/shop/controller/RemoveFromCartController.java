package com.codecool.shop.controller;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/remove-from-cart"})
public class RemoveFromCartController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productToRemove = request.getParameter("item");
        ProductDao productDataStore = ProductDaoMem.getInstance();
        Cart cart = Cart.getInstance();

        for (Product product : productDataStore.getAll()) {
            if (product.getName().equals(productToRemove)) {
                cart.remove(product);
            }
        }

        response.sendRedirect(request.getHeader("referer"));
    }
}
