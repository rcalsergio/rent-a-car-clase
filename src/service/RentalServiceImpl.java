package service;

import model.Car;
import model.Client;
import model.Rental;
import model.RentalOffice;
import repository.RentalRepository;
import repository.IRentalRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalServiceImpl implements IRentalService{
    private IRentalRepository repository;
    public RentalServiceImpl() {
        repository = RentalRepository.getRentalRepository();
    }

    public void add(Long id, LocalDate startDate, LocalDate endDate, Car car, Client client, RentalOffice rentalOffice) {
        Rental rental = new Rental(id, startDate, endDate, car, client, rentalOffice);
        repository.add(rental);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Long id, LocalDate startDate, LocalDate endDate, Car car, Client client, RentalOffice rentalOffice) {
        Rental rental = new Rental(id, startDate, endDate, car, client, rentalOffice);
        repository.update(rental);
    }

    public Rental findById(Long id) {
        return repository.findById(id);
    }

}
