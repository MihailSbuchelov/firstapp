package ru.gb.dao;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Buyer;

public interface BuyerDao extends CrudRepository<Buyer, Long> {
}