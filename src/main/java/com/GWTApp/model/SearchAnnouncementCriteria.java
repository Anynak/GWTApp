package com.GWTApp.model;

public class SearchAnnouncementCriteria {
    private Float priceMin;
    private Float priceMax;
    private Integer mileageMin;
    private Integer mileageMax;
    private Integer releaseYearMin;
    private Integer releaseYearMax;
    private String color;
    private String vehicleBrandName;
    private String vehicleModelName;

    public Float getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Float priceMin) {
        this.priceMin = priceMin;
    }

    public Float getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Float priceMax) {
        this.priceMax = priceMax;
    }

    public Integer getMileageMin() {
        return mileageMin;
    }

    public void setMileageMin(Integer mileageMin) {
        this.mileageMin = mileageMin;
    }

    public Integer getMileageMax() {
        return mileageMax;
    }

    public void setMileageMax(Integer mileageMax) {
        this.mileageMax = mileageMax;
    }

    public Integer getReleaseYearMin() {
        return releaseYearMin;
    }

    public void setReleaseYearMin(Integer releaseYearMin) {
        this.releaseYearMin = releaseYearMin;
    }

    public Integer getReleaseYearMax() {
        return releaseYearMax;
    }

    public void setReleaseYearMax(Integer releaseYearMax) {
        this.releaseYearMax = releaseYearMax;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }
}
