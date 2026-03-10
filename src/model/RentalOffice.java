package model;

import java.util.ArrayList;

public class RentalOffice {

    private long id;
    private String address;
    private int freeForDelivery;

    public RentalOffice(long id, String address, int freeForDelivery) {
        this.id = id;
        this.address = address;
        this.freeForDelivery = freeForDelivery;
    }

    public RentalOffice(String address, int freeForDelivery) {
        this.address = address;
        this.freeForDelivery = freeForDelivery;
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

    public int getFreeForDelivery() {
        return freeForDelivery;
    }

    public void setFreeForDelivery(int freeForDelivery) {
        this.freeForDelivery = freeForDelivery;
    }
}
