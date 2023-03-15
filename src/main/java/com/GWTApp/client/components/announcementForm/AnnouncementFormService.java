package com.GWTApp.client.components.announcementForm;

import com.GWTApp.client.repositories.AnnouncementRepository;
import com.GWTApp.client.repositories.VehicleBrandRepository;
import com.GWTApp.client.repositories.VehicleModelRepository;
import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.model.AnnouncementRequest;
import com.GWTApp.model.AnnouncementResponse;
import com.GWTApp.model.VehicleBrand;
import com.GWTApp.model.VehicleModel;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class AnnouncementFormService {
    private final AnnouncementFormView announcementFormView;
    private final VehicleModelRepository vehicleModelRepository;
    private final AnnouncementRepository announcementRepository;
    private final VehicleBrandRepository vehicleBrandRepository;

    public AnnouncementFormService(AnnouncementFormView announcementFormView) {
        this.announcementFormView = announcementFormView;
        this.vehicleModelRepository = GWT.create(VehicleModelRepository.class);
        this.announcementRepository = GWT.create(AnnouncementRepository.class);
        this.vehicleBrandRepository = GWT.create(VehicleBrandRepository.class);
    }

    public void setModels(Long brandId) {
        vehicleModelRepository.getVehicleModelsByBrand(SecurityStorage.getAccessToken(), brandId, new MethodCallback<List<VehicleModel>>() {

            @Override
            public void onFailure(Method method, Throwable throwable) {
                announcementFormView.handleError(method);
            }

            @Override
            public void onSuccess(Method method, List<VehicleModel> vehicleModels) {
                announcementFormView.updateVehicleModels(vehicleModels);
            }
        });
    }

    public void setBrands() {
        vehicleBrandRepository.getVehicleBrands(SecurityStorage.getAccessToken(), new MethodCallback<List<VehicleBrand>>() {

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

    public void sendAnnouncement(AnnouncementResponse announcementResponse) {
        announcementRepository.addAnnouncement(SecurityStorage.getAccessToken(), announcementResponse, new MethodCallback<AnnouncementRequest>() {

            @Override
            public void onFailure(Method method, Throwable throwable) {
                announcementFormView.handleError(method);
            }

            @Override
            public void onSuccess(Method method, AnnouncementRequest announcementRequest) {
                announcementFormView.sendSuccess();
            }

        });

    }


}
