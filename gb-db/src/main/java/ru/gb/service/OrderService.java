package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.OrdersDao;
import ru.gb.entity.Orders;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrdersDao ordersDao;

    public List<Orders> findAllSortedByCost() {
        return (List<Orders>) ordersDao.findAll(Sort.by(Sort.Direction.ASC, "cost"));
    }

}