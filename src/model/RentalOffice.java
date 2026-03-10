package model;

public class RentalOffice {

    private long id;
    private String address;
    private int feeForDelivery;

    public RentalOffice(long id, String address, int feeForDelivery) {
        this.id = id;
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }

    public RentalOffice(String address, int feeForDelivery) {
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getFeeForDelivery() {
        return feeForDelivery;
    }

    public void setFeeForDelivery(int feeForDelivery) {
        this.feeForDelivery = feeForDelivery;
    }



    @Override
    public String toString() {
        return id + " " + address + " " + feeForDelivery;
    }
}
