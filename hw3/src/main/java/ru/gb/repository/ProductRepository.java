package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(0, "Bread", 345));
        products.add(new Product(1, "Water", 4444.3));
        products.add(new Product(2, "Orange", 3.0));
        products.add(new Product(3, "Milk", 345));
        products.add(new Product(4, "Banana", 345));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id) {

        if (id >= 0 && id < (products.size()))
            return Optional.of(products.get(id));
        else return Optional.empty();
    }
}
