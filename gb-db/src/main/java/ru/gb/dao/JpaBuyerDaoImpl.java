package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaBuyerDaoImpl implements BuyerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Buyer> findAll() {
        return entityManager.createQuery("select b from Buyer b").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Buyer findById(Long id) {
        TypedQuery<Buyer> query = entityManager.createNamedQuery("Buyer.findById", Buyer.class);
        query.setParameter("id", id);
        return (Buyer) query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        Buyer buyer = new Buyer();
        buyer.setId(id);
        buyer = entityManager.merge(buyer);
        entityManager.remove(buyer);
    }

    @Override
    public void delete(Buyer buyer) {
        buyer = entityManager.merge(buyer);
        entityManager.remove(buyer);
    }
}