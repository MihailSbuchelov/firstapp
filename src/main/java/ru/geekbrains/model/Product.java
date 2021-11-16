package ru.geekbrains.model;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Product {
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private double cost;
}
