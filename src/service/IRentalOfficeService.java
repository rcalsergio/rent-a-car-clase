package service;

import model.RentalOffice;

import java.util.ArrayList;

public interface IRentalOfficeService {
    RentalOffice findById(Long id);
    void add(String name, int pricePerDay);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, String name, int pricePerDay);

}
