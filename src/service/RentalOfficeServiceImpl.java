package service;


import model.RentalOffice;

import repository.IRentalOfficeRepository;
import repository.RentalOfficeRepository;

import java.util.ArrayList;

public class RentalOfficeServiceImpl implements IRentalOfficeService {

    private IRentalOfficeRepository repository;

    public RentalOfficeServiceImpl(){
        repository = RentalOfficeRepository.getRentalOfficeRepository();
    }

    public void add(String address, int freeForDelivery) {
        RentalOffice rentalOffice = new RentalOffice(address,freeForDelivery);
        repository.add(rentalOffice);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }

    public void update(RentalOffice rentalOffice) {
        repository.update(rentalOffice);
    }
}
