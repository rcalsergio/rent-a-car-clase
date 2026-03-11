package service;

import model.Car;
import model.Client;
import model.Rental;
import model.RentalOffice;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRentalService {
    void update(Long id, LocalDate startDate, LocalDate endDate, Car car, Client client, RentalOffice rentalOffice);

    Rental findById(Long id);

    void add(Long id, LocalDate startDate, LocalDate endDate, Car car, Client client, RentalOffice rentalOffice);

    void deleteById(Long id);

    ArrayList findAll();
}

