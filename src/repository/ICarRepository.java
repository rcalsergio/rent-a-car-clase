package repository;

import model.Car;

import java.util.ArrayList;

public interface ICarRepository {
    void add(Car car);
    void deleteById(Long id);
    ArrayList findAll();
    Car findById(Long id);
    void update(Car car);
}
