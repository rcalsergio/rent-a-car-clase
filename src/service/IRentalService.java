package service;

import model.Rental;

import java.util.ArrayList;
import java.util.Date;

public interface IRentalService {
    Rental findById(Long id);
    void add(Long idClient, Long idCar, Date startDate, Date endDate);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, Long idClient, Long idCar, Date startDate, Date endDate);

}
