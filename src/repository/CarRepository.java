package repository;

import model.Car;

import java.util.ArrayList;

public class CarRepository implements ICarRepository {

    private ArrayList<Car> cars;
    private static CarRepository carRepository;

    private CarRepository() {
        cars = new ArrayList<>();
    }

    public static CarRepository getCarRepository() {
        if (carRepository == null) {
            carRepository = new CarRepository();
        }
        return carRepository;
    }

    public void add(Car car) {
        car.setId(nextIdAvailable());
        cars.add(car);
    }

    public void update(Car car) {
        cars.set(cars.indexOf(findById(car.getId())), car);
    }

    public ArrayList findAll() {
        return cars;
    }

    public void deleteById(Long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(car);
                break;
            }
        }
    }

    public Long nextIdAvailable() {
        if (!cars.isEmpty()) {
            return cars.get(cars.size() - 1).getId() + 1;
        } else {
            return (long) 1;
        }
    }

    public Car findById(Long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
}

