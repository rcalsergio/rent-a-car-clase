package service;

import model.*;
import repository.*;

import java.util.ArrayList;
import java.util.Date;

public class RentalServiceImpl implements IRentalService {

    private IRentalRepository rentalRepository;
    private IClientService clientService;
    private ICarService carService;

    public RentalServiceImpl() {
        this.rentalRepository = RentalRepository.getRentalRepository();
        this.clientService = new ClientServiceImpl();
        this.carService = new CarServiceImpl();
    }

    @Override
    public Rental findById(Long id) {
        return this.rentalRepository.findById(id);
    }

    @Override
    public void add(Long idClient, Long idCar, Date startDate, Date endDate) {

        Client client = this.clientService.findById(idClient);
        Car car = this.carService.findById(idCar);

        Rental rental = new Rental(client, car, startDate, endDate);

        client.addRental(rental);
        car.addRental(rental);

        this.rentalRepository.add(rental);
    }

    @Override
    public void deleteById(Long id) {
        this.rentalRepository.deleteById(id);
    }

    @Override
    public ArrayList findAll() {
        return this.rentalRepository.findAll();
    }

    @Override
    public void update(Long id, Long idClient, Long idCar, Date startDate, Date endDate) {
        this.rentalRepository.update(new Rental(id, clientService.findById(idClient), carService.findById(idCar), startDate, endDate));
    }
}
