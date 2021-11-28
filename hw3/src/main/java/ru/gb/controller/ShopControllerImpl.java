package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.model.Cart;
import ru.gb.repository.ProductRepository;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shop")
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
        return "assortment";
    }

    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public void addProductFromRepoToCartById(@PathVariable Integer id) {
        productRepository.findById(id).ifPresent(cart);
    }

    @RequestMapping(path = "/dell/{id}", method = RequestMethod.GET)
    public void deleteProductFromCartById(@PathVariable Integer id) {
        cart.dellByProductId(id);
    }

    public String getProductsCartForShow() {
        return cart.showProductList();
    }

    public void enterToShop() {
        this.cart = getCart();
    }
}
