package ru.gb.springTest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.springTest.model.Product;

import java.util.List;

@Component("repositoryImpl")
public class RepositoryImpl implements Repository {

    private List<Product> productList;

    @Autowired
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> getRepositoryProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return productList.get(id);
    }

    public void printRepositoryImpl() {
        if (!productList.isEmpty()) {
            System.out.println("Всего доступно для заказа " + productList.size() + " товаров");
            for (Product p : productList) {
                System.out.println("ID: " + p.getId() + ", " + "Наименование: " + p.getTitle() + ", " + "Стоимость: " + p.getCost() + ";");
            }
        }
    }

}
