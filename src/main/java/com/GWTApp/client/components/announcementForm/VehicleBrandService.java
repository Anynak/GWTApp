package com.GWTApp.client.components.announcementForm;

import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.model.VehicleBrand;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class VehicleBrandService {
    private final VehicleBrandRepository vehicleBrandRepository;

    private final AnnouncementFormView announcementFormView;

    public VehicleBrandService(AnnouncementFormView announcementFormView) {
        this.announcementFormView = announcementFormView;
        this.vehicleBrandRepository  = GWT.create(VehicleBrandRepository.class);
    }

    public void setBrands(){
        vehicleBrandRepository.getVehicleBrands(SecurityStorage.getAccessToken(), new MethodCallback<List<VehicleBrand>>(){

            @Override
            public void onFailure(Method method, Throwable throwable) {
                announcementFormView.handleError(method);
            }

            @Override
            public void onSuccess(Method method, List<VehicleBrand> vehicleBrands) {
                announcementFormView.setVehicleBrands(vehicleBrands);
            }
        });
    }

}
