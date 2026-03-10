package service;

import model.Car;
import model.Model;
import model.RentalOffice;

import java.util.ArrayList;

public interface ICarService {
    Car findById(Long id);
    void add(String licensePlate, Long idModel, Long idRentalOffice);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, String licensePlate, Long idModel, Long idRentalOffice);

}
