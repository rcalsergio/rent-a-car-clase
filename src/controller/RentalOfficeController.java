package controller;

import model.Model;
import model.RentalOffice;
import service.IRentalOfficeService;
import service.ModelServiceImpl;
import service.RentalOfficeServiceImpl;

import java.util.ArrayList;

public class RentalOfficeController {

    private IRentalOfficeService service;

    public RentalOfficeController(){
        service = new RentalOfficeServiceImpl();
    }

    public void add(String address,int freeForDelivery ){
        service.add(address,freeForDelivery);
    }

    public void deleteById(long id){
        service.deleteById(id);
    }

    public ArrayList findAll(){
        return service.findAll();
    }

    public void update(long id, String address, int freeForDelivery){
       RentalOffice rentalOffice = new RentalOffice(id,address,freeForDelivery);
        service.update(rentalOffice);
    }
}
