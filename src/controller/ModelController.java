package controller;


import model.Model;
import service.ModelServiceImpl;
import service.IModelService;

import java.util.ArrayList;

public class ModelController {

    private IModelService service;
    public ModelController() {
        service = new ModelServiceImpl();
    }

    public void add(String name, int pricePerDay){
        service.add(name, pricePerDay);

    }

    public Model findById(Long id){
        return service.findById(id);
    }


    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }


    public void update(Long id, String name, int pricePerDay){
        service.update(id, name, pricePerDay);
    }


}
