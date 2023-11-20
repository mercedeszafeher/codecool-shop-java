package com.codecool.shop.controller;

import com.codecool.shop.model.Cart;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.service.Util;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/endpage"})
public class EndPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = Cart.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("itemsSum", cart.itemCount());
        context.setVariable("cartItems", cart.getProducts());
        context.setVariable("itemsPrice", Util.getItemsPrice(cart.getProducts()));
        engine.process("product/endpage.html", context, resp.getWriter());
    }

}