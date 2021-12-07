package ru.gb.dao;

import ru.gb.entity.Orders;

public interface OrdersDao {
    Orders save(Orders orders);
}