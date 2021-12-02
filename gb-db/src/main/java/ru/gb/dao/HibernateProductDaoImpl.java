package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

@Repository
@RequiredArgsConstructor
public class HibernateProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product p").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return (Product) sessionFactory.getCurrentSession().getNamedQuery("Product.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public String findTitleById(Long id) {
        String title = "";
        Product p = (Product) sessionFactory.getCurrentSession().getNamedQuery("Product.findTitleById").setParameter("id", id).uniqueResult();
        return p.getTitle();
    }
}
