package com.GWTApp.model;

public class AnnouncementResponse {
    private Vehicle vehicle;
    private Float price;
    private String comment;

    public AnnouncementResponse(Vehicle vehicle, Float price, String comment) {
        this.vehicle = vehicle;
        this.price = price;
        this.comment = comment;
    }

    public AnnouncementResponse() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
