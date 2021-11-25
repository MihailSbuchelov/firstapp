package ru.gb.springTest.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Data
@Component("product")
@Scope("prototype")
public class Product {
    @NonNull
    int id;
    @NonNull
    String title;
    @NonNull
    double cost;

    String[] titles = {"Товар1", "Товар22", "Товар32", "Товар43", "Товар4", "Товар55"};
    Random random = new Random();
    private static int index = 0;


    public Product() {
        this.id = index++;
        this.title = titles[random.nextInt(titles.length-1)];
        this.cost = random.nextDouble();
    }
}
