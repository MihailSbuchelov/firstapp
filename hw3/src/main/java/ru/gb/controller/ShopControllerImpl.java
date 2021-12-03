package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Cart;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShopControllerImpl implements ShopController {
    private final ProductRepository productRepository;
    private Cart cart;

    @Lookup
    @Override
    public Cart getCart() {
        return null;
    }

    @RequestMapping("/assortment")
    public String showAssortment(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("listIdAssortment", productRepository.getListId());
        return "assortment";
    }

    @GetMapping(path = "/add/")
    public String addProductFromRepoToCartById(@RequestParam(name = "id") Integer id) {
        productRepository.findById(id).ifPresent(cart);
        return "add-product-page";
    }

    @GetMapping(path = "/del/")
    public String deleteProductFromCartById(@RequestParam(name = "id") Integer id) {
        cart.dellByProductId(id);
        return "del-product-page";
    }

    public String getProductsCartForShow() {
        return cart.showProductList();
    }

    public List<Integer> getListIdCart() {
        return cart.getListIdProducts();
    }

    public List<Integer> getListIdAssortment() {
        return productRepository.getListId();
    }

    public void enterToShop() {
        this.cart = getCart();
    }
}
