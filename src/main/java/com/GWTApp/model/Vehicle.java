package com.GWTApp.model;

public class Vehicle {

    private Integer mileage = 0;
    private Integer releaseYear;
    private String color;
    private VehicleModel vehicleModel;

    public Vehicle() {
    }

    public Vehicle(Integer mileage, Integer releaseYear, String color, VehicleModel vehicleModel) {
        this.mileage = mileage;
        this.releaseYear = releaseYear;
        this.color = color;
        this.vehicleModel = vehicleModel;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
