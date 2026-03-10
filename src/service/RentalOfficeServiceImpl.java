package service;

import model.Model;
import repository.IModelRepository;
import repository.ModelRepository;

import java.util.ArrayList;

public class RentalOfficeServiceImpl implements IRentalOfficeService{
    private IModelRepository repository;
    public RentalOfficeServiceImpl() {
        repository = ModelRepository.getModelRepository();
    }

    public void add(String address, int feeForDelivery) {
        Model model = new Model(address, feeForDelivery);
        repository.add(model);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }


    public Model findById(Long id) {
        return repository.findById(id);
    }


    public void update(Long id, String address, int feeForDelivery) {
        Model model = new Model(id, address, feeForDelivery);
        repository.update(model);
    }
}
