package ru.geekbrains.controller;

import ru.geekbrains.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = "/product")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Product> list = new ArrayList<>(10);
        resp10Products(list, resp);
    }

    private void resp10Products(List<Product> list, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>Products list</h1>");
        for (int i = 0; i < 10; i++) {
            list.add(new Product(i, "title" + i, i * 5));
            response.getWriter().println("<h3>product ID: " + list.get(i).getId() + "</h3>");
            response.getWriter().println("<h3>product Title: " + list.get(i).getTitle() + "</h3>");
            response.getWriter().println("<h3>product Cost: " + list.get(i).getCost() + "</h3>");
            response.getWriter().println("______________________");
            response.getWriter().println();
        }
    }
}
