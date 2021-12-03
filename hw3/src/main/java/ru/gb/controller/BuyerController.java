package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.model.Buyer;

@Controller
@RequiredArgsConstructor
public class BuyerController {

    private final Buyer buyer;

    @RequestMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", buyer.showCart());
        model.addAttribute("listId", buyer.listIdCart());
        return "cart";
    }
}