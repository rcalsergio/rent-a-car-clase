package controller;

import model.Car;
import model.Client;
import model.Rental;
import model.RentalOffice;
import service.RentalServiceImpl;
import service.IRentalService;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalController {
    private IRentalService service;
    public RentalController() {
        service = new RentalServiceImpl();
    }

    public void add(Long id,LocalDate startDate, LocalDate endDate, Car car, Client client, RentalOffice rentalOffice){
        service.add(id, startDate, endDate, car, client, rentalOffice);

    }

    public Rental findById(Long id){
        return service.findById(id);
    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }


    public void update(Long id, LocalDate startDate, LocalDate endDate, Car car, Client client, RentalOffice rentalOffice){
        service.update(id,startDate, endDate, car, client, rentalOffice);
    }


}
