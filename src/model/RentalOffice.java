package model;

public class RentalOffice {
    private long id;
    private String address;
    private Integer feeForDelivery;


    public RentalOffice(long id, String address, Integer feeForDelivery) {
        this.id = id;
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }

    public RentalOffice(String address, Integer feeForDelivery) {
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFeeForDelivery() {
        return feeForDelivery;
    }

    public void setFeeForDelivery(Integer feeForDelivery) {
        this.feeForDelivery = feeForDelivery;
    }


    @Override
    public String toString() {
        return id + " " + address + ". Fee for delivery: " + feeForDelivery;
    }
}
