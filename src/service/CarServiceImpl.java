package service;

import model.Car;
import repository.CarRepository;
import repository.ICarRepository;

import java.util.ArrayList;

public class CarServiceImpl implements ICarService{

    private ICarRepository repository;
    private IModelService modelService;
    private IRentalOfficeService rentalOfficeService;

    public CarServiceImpl() {
        repository = CarRepository.getCarRepository();
        modelService = new ModelServiceImpl();
        rentalOfficeService = new RentalOfficeServiceImpl();
    }

    public void add(String licensePlate, Long idModel, Long idRentalOffice) {
        repository.add(new Car(licensePlate, modelService.findById(idModel), rentalOfficeService.findById(idRentalOffice)));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }



    public Car findById(Long id) {
        return repository.findById(id);
    }


    public void update(Long id, String licensePlate, Long idModel, Long idRentalOffice) {
        repository.update(new Car(id, licensePlate, modelService.findById(idModel), rentalOfficeService.findById(idRentalOffice)));
    }

}
