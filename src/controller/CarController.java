package controller;

import model.Car;
import service.CarServiceImpl;
import service.ICarService;


import java.util.ArrayList;

public class CarController {
    private ICarService service;
    public CarController() {
        service = new CarServiceImpl();
    }

    public void add(String licensePlate, Long idModel, Long idRentalOffice){
        service.add(licensePlate, idModel, idRentalOffice);

    }

    public Car findById(Long id){
        return service.findById(id);
    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }


    public void update(Long id,String licensePlate, Long idModel, Long idRentalOffice){
        service.update(id, licensePlate, idModel, idRentalOffice);
    }


}
