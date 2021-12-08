package ru.gb.dao;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Manufacturer;

public interface ManufacturerDao extends CrudRepository<Manufacturer, Long> {
}