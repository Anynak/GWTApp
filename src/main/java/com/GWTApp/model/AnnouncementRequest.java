package com.GWTApp.model;

public class AnnouncementRequest {
    private Long announcementId;
    private Vehicle vehicle;
    private Float price;
    private String currency;
    private String comment;

    public AnnouncementRequest() {
    }

    public AnnouncementRequest(Long announcementId, Vehicle vehicle, Float price, String currency, String comment) {
        this.announcementId = announcementId;
        this.vehicle = vehicle;
        this.price = price;
        this.currency = currency;
        this.comment = comment;
    }

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
