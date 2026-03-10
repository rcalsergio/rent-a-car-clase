package controller;


import model.Car;
import model.Model;
import model.RentalOffice;
import service.ICarService;
import service.CarServiceImpl;

import java.util.ArrayList;

public class CarController {

    private ICarService service;
    public CarController() {
        service = new CarServiceImpl();
    }

    public void add(String licensePlate, Long idModel, Long idRentalOffice){
        service.add(licensePlate,idModel,idRentalOffice);

    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public Car findById(Long id){
        return service.findById(id);
    }

    public ArrayList findAll(){
        return service.findAll();
    }


    public void update(Long id, String licensePlate,Long idModel, Long idRentalOffice){
        service.update(id, licensePlate,idModel,idRentalOffice);
    }


}
