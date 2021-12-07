package ru.gb.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;


public interface BuyerDao {
    Iterable<Buyer> findAll();

    @Transactional
    Buyer findById(Long id);

    void deleteById(Long id);

    void delete(Buyer buyer);
}