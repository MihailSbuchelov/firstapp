package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Orders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JpaOrdersDaoImpl implements OrdersDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Orders save(Orders orders) {
        if (orders.getId() == null) {
            entityManager.persist(orders);
        } else {
            entityManager.merge(orders);
        }
        return orders;
    }
}