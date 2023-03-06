package com.GWTApp.model;

public class VehicleBrand {
    private Long vehicleBrandId;
    private String vehicleBrandName;

    public VehicleBrand() {
    }

    public VehicleBrand(Long vehicleBrandId, String vehicleBrandName) {
        this.vehicleBrandId = vehicleBrandId;
        this.vehicleBrandName = vehicleBrandName;
    }

    public Long getVehicleBrandId() {
        return vehicleBrandId;
    }

    public void setVehicleBrandId(Long vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }
}
