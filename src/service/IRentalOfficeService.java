package service;

import model.Model;

import java.util.ArrayList;

public interface IRentalOfficeService {
    Model findById(Long id);
    void add(String address, int feeForDelivery);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, String address, int feeForDelivery);

}
