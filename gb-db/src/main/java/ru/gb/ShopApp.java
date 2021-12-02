package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.ProductDao;

public class ShopApp {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println(productDao.findAll());
        System.out.println("-----------------------");
        System.out.println(productDao.findById(3L));
        System.out.println(productDao.findTitleById(3L));
//        System.out.println("-----------------------");
//OldJdbcProductDao oldJdbcManufacturerDao = new OldJdbcProductDao();
//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }
    }
}
