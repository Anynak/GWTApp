package com.GWTApp.model;

public class VehicleModel {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;

    public VehicleModel() {
    }

    public VehicleModel(Long vehicleModelId, String vehicleModelName, VehicleBrand vehicleBrand) {
        this.vehicleModelId = vehicleModelId;
        this.vehicleModelName = vehicleModelName;
        this.vehicleBrand = vehicleBrand;
    }

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleBrand getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(VehicleBrand vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
}
