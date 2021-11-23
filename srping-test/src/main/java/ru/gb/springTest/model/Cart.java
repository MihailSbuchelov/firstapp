package ru.gb.springTest.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.springTest.repository.RepositoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component("cart")
@Scope("prototype")
public class Cart {

    private RepositoryImpl repositoryAvailable;

    public CopyOnWriteArrayList<Product> getCartList() {
        return cartList;
    }

    private CopyOnWriteArrayList<Product> cartList;

    public Cart() {
        this.cartList = new CopyOnWriteArrayList<>();
    }

    @Autowired
    public void setRepositoryAvailable(RepositoryImpl repositoryAvailable) {
        this.repositoryAvailable = repositoryAvailable;
    }

    public CopyOnWriteArrayList<Product> addProductToCart(int id) {
        for (Product p : repositoryAvailable.getRepositoryProducts()) {
            if (p.getId() == id) {
                cartList.add(p);
            }
        }
        return cartList;
    }

    public CopyOnWriteArrayList<Product> dellProductFromCart(int id) {
        for (Product p : cartList) {
            if (p.getId() == id) {
                cartList.remove(p);
            }
        }
        return cartList;
    }

    public void showCart() {
        System.out.println("Продукты корзины:");
        if (cartList.isEmpty()) {
            System.out.println("корзина пуста. Добавьте продукты (add)");
        } else {
            for (Product p : cartList) {
                System.out.println("ID: " + p.getId() + ", Наименование: " + p.getTitle() + ", Стоимость: " + p.getCost() + ";");
            }
        }
    }

    public CopyOnWriteArrayList<Product> removeAllElement(CopyOnWriteArrayList<Product> cartList) {
        for (Product p : cartList) {
            this.cartList.remove(p);
        }
        return this.cartList;
    }

    public CopyOnWriteArrayList<Product> clearCart() {
        return removeAllElement(cartList);
    }

    public RepositoryImpl getRepositoryAvailable() {
        return repositoryAvailable;
    }
}
