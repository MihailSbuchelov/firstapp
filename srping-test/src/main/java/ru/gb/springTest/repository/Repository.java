package ru.gb.springTest.repository;

import ru.gb.springTest.model.Product;

import java.util.List;

public interface Repository {
    public List<Product> getRepositoryProducts();
}
