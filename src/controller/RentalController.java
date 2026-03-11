package controller;


import model.Rental;
import service.RentalServiceImpl;
import service.IRentalService;

import java.util.ArrayList;
import java.util.Date;

public class RentalController {

    private IRentalService service;
    public RentalController() {
        service = new RentalServiceImpl();
    }

    public void add(Long idClien, Long idCar, Date startDate, Date endDate){
        service.add(idClien, idCar, startDate, endDate);
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


    public void update(Long id,Long idClien, Long idCar, Date startDate, Date endDate){
        service.update(id, idClien, idCar, startDate, endDate);
    }


}
