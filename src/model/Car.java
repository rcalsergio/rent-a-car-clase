package model;

public class Car {
    private Long id;
    private String licensePlate;
    private Model model;
    private RentalOffice rentalOffice;

    public Car(Long id, String licensePlate, Model model, RentalOffice rentalOffice) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalOffice = rentalOffice;
    }

    public Car(String licensePlate, Model model, RentalOffice rentalOffice) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalOffice = rentalOffice;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
    }

    @Override
    public String toString() {
        return id + " " + licensePlate ;
    }
}
