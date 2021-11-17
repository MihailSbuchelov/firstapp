package ru.geekbrains.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private double cost;
}
