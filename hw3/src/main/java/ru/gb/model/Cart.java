package ru.gb.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {
    private final Map<Integer, Product> products = new HashMap<>();
    private final List<Integer> listId = new ArrayList<>();

    public void add(Product product) {
        products.put(product.getId(), product);
        listId.add(product.getId());
    }

    public void dellByProductId(Integer id) {
        products.remove(id);
        listId.remove(id);
    }

    public String showProductList() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Product> pair : products.entrySet()) {
            stringBuilder.append("ID: " + pair.getValue().getId() + "\n")
                    .append("Title: " + pair.getValue().getTitle() + "\n")
                    .append("Cost: " + pair.getValue().getCost() + "\n")
                    .append(";");
        }
        return stringBuilder.toString();
    }

    public List<Integer> getListIdProducts() {
        return listId;
    }

    @Override
    public void accept(Product product) {
        add(product);
    }
}
