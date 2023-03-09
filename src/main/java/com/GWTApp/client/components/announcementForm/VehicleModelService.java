package com.GWTApp.client.components.announcementForm;

import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.model.VehicleBrand;
import com.GWTApp.model.VehicleModel;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class VehicleModelService {
    private final VehicleModelRepository vehicleModelRepository;
    private final AnnouncementFormView announcementFormView;

    public VehicleModelService(AnnouncementFormView announcementFormView) {
        this.vehicleModelRepository = GWT.create(VehicleModelRepository.class);
        this.announcementFormView = announcementFormView;
    }

    public void setModels(Long brandId){
        vehicleModelRepository.getVehicleModelsByBrand(SecurityStorage.getAccessToken(), brandId, new MethodCallback<List<VehicleModel>>(){

            @Override
            public void onFailure(Method method, Throwable throwable) {
                announcementFormView.showError(method);
            }

            @Override
            public void onSuccess(Method method, List<VehicleModel> vehicleModels) {
                announcementFormView.updateVehicleModels(vehicleModels);
            }
        });
    }
}
