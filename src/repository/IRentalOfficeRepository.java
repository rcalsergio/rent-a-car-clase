package repository;

import model.RentalOffice;

import java.util.ArrayList;

public interface IRentalOfficeRepository {

    void add(RentalOffice rentalOffice);
    void deleteById(long id);
    ArrayList findAll();
    RentalOffice findById(long id);
    void update(RentalOffice rentalOffice);

}
