package service;

import model.Model;
import model.RentalOffice;

import java.util.ArrayList;

public interface IRentalOfficeService {

    void add(String address, int freeForDelivery);
    void deleteById(long id);
    ArrayList findAll();
    void update(RentalOffice rentalOffice);
}
