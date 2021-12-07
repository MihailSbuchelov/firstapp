package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.*;
import ru.gb.entity.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

public class ShopApp {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        OrdersDao ordersDao = context.getBean(OrdersDao.class);
        BuyerDao buyerDao = context.getBean(BuyerDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        Product p = productDao.findById(1L);
        Buyer b = buyerDao.findById(1L);

        System.out.println(p);
        System.out.println(b);
        Orders orders = Orders.builder()
                .id(3L)
                .products(new HashSet<Product>(((List<Product>) productDao.findAll()).subList(1, 5)))
                .cost(BigDecimal.valueOf(3.1223))
                .buyer(b)
                .build();
        System.out.println(orders.toString());
//
        ordersDao.save(orders);
        System.out.println(orders);


//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        CartDao cartDao = context.getBean(CartDao.class);

//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }


//        System.out.println(manufacturerDao.findNameById(3L));
//        System.out.println("-----------------------");
//        System.out.println(manufacturerDao.findById(4L).getProducts());
//        Manufacturer manufacturer = manufacturerDao.findById(4L);
        // УДАЛЕНИЕ
//        manufacturerDao.delete(manufacturer);
//        System.out.println("-----------------------");
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        Manufacturer testManufacturer = Manufacturer.builder()
//                .name("Company 4")
//                .products(new HashSet<Product>(((List<Product>) productDao.findAll()).subList(1, 5)))
//                .build();
//        System.out.println(testManufacturer);
//
//        manufacturerDao.save(testManufacturer);
//        System.out.println(testManufacturer);
//        Manufacturer savedManufacturer = manufacturerDao.findById(3L);
//        savedManufacturer.setName("Apple");
//        manufacturerDao.save(savedManufacturer);

//        manufacturerDao.deleteById(3L);

//        Product product = ((List<Product>) productDao.findAll()).get(5);
//
//        Cart cart = new Cart();
//        cart.addProduct(product);
//        cartDao.save(cart);
    }
}