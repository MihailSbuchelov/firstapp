package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import java.util.Collection;

//@Repository
@RequiredArgsConstructor
public class HibernateProductDao implements ProductDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product p").list();
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return (Product) sessionFactory.getCurrentSession().getNamedQuery("Product.findById");
    }

    @Override
    @Transactional
    public Product save(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
        return product;
    }

    @Override
    public void deleteAll(Collection<Product> products) {

    }
}
