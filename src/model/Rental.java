package model;

import java.util.Date;

public class Rental {

    private Long id;
    private Client client;
    private Car car;
    private Date startDate;
    private Date endDate;

    public Rental(Long id, Client client, Car car, Date startDate, Date endDate) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rental(Client client, Car car, Date startDate, Date endDate) {
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return """
           ┌─ Rental
           │ id: %s
           │ car: %s
           │ client: %s
           │ startDate: %s
           │ endDate: %s
           └────────────
           """.formatted(id, car.getModel(), client.getName(), startDate, endDate);
    }
}
