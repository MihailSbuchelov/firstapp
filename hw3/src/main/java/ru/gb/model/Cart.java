package ru.gb.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {
    private final Map<Integer, Product> products = new HashMap<>();

    public void add(Product product) {
        products.put(product.getId(), product);
    }

    public void dellByProductId(Integer id) {
        products.remove(id);
    }

    public String showProductList() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Product> pair : products.entrySet()) {
            stringBuilder.append(pair.getValue().getId())
                    .append(pair.getValue().getTitle())
                    .append(pair.getValue().getCost())
                    .append(";");
        }
        return stringBuilder.toString();
    }

    @Override
    public void accept(Product product) {
        add(product);
    }
}
