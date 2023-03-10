package com.GWTApp.client.components.announcementForm;

import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.model.VehicleBrand;
import com.GWTApp.model.VehicleModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;

import java.util.List;
import java.util.Objects;

//https://stackoverflow.com/questions/22629632/gwt-listbox-onchangehandler
public class AnnouncementFormView extends Composite {
    @UiField
    VerticalPanel mainPanel;
    @UiField
    ListBox brands;
    @UiField
    ListBox models;
    @UiField
    TextBox releaseYearTextBox;
    @UiField
    TextBox colorTextBox;
    @UiField
    TextBox mileageTextBox;
    @UiField
    TextBox priceTextBox;
    @UiField
    TextBox commentTextBox;
    @UiField
    Button submitBtn;

    private final ApiErrorView apiErrorView = new ApiErrorView();
    private final MainPageView parentView;
    private final VehicleModelService modelService = new VehicleModelService(this);

    public void handleError(Method method) {
        this.parentView.handleError(method);

    }

    interface AnnouncementFormUiBinder extends UiBinder<VerticalPanel, AnnouncementFormView> {
    }

    private static final AnnouncementFormUiBinder ourUiBinder = GWT.create(AnnouncementFormUiBinder.class);

    public AnnouncementFormView(MainPageView mainPageView) {

        this.parentView = mainPageView;
        initWidget(ourUiBinder.createAndBindUi(this));
        mainPanel.add(apiErrorView);

        initBrands();
        initModels();

    }

    private void initBrands(){
        brands.addItem("select brand", "-1");
        brands.addChangeHandler((changeEvent) -> {
            modelService.setModels(Long.valueOf(brands.getSelectedValue()));
            models.setVisible(true);
            if (Objects.equals(brands.getValue(0), "-1")) brands.removeItem(0);
        });
        VehicleBrandService vehicleBrandService = new VehicleBrandService(this);
        vehicleBrandService.setBrands();
    }

    private void initModels(){
        models.setVisible(false);
    }

    public void setVehicleBrands(List<VehicleBrand> vehicleBrands) {
        for (VehicleBrand brand : vehicleBrands) {
            brands.addItem(brand.getVehicleBrandName(), brand.getVehicleBrandId().toString());
        }
    }

    public void updateVehicleModels(List<VehicleModel> vehicleModels) {
        models.clear();
        for (VehicleModel vehicleModel : vehicleModels) {
            models.addItem(vehicleModel.getVehicleModelName(), vehicleModel.getVehicleModelId().toString());
        }
    }

}