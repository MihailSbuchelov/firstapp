package ru.gb.dao;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {
}