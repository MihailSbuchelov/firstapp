package ru.gb.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.entity.Orders;

public interface OrdersDao extends PagingAndSortingRepository<Orders, Long> {
}