package com.GWTApp.client.components.announcementForm;

import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.model.AnnouncementResponse;
import com.GWTApp.model.Vehicle;
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
    private static final AnnouncementFormUiBinder ourUiBinder = GWT.create(AnnouncementFormUiBinder.class);
    private final ApiErrorView apiErrorView = new ApiErrorView();
    private final MainPageView parentView;
    private final AnnouncementFormService announcementFormService = new AnnouncementFormService(this);
    @UiField
    VerticalPanel mainPanel;
    @UiField
    ListBox brands;
    @UiField
    ListBox models;
    @UiField
    IntegerBox releaseYearIntBox;
    @UiField
    TextBox colorTextBox;
    @UiField
    IntegerBox mileageIntBox;
    @UiField
    DoubleBox priceDoubleBox;
    @UiField
    TextArea commentTextArea;
    @UiField
    Button submitBtn;

    @UiField
    Button homeBtn;

    public AnnouncementFormView(MainPageView mainPageView) {

        this.parentView = mainPageView;
        initWidget(ourUiBinder.createAndBindUi(this));
        mainPanel.add(apiErrorView);
        this.submitBtn.addClickHandler(clickEvent -> sendAnnouncement());

        this.homeBtn.addClickHandler(clickEvent -> toHomePage());
        initBrands();
        initModels();


    }

    private void toHomePage() {
        this.parentView.showMainPage();
    }

    public void handleError(Method method) {
        this.parentView.handleError(method);

    }

    private void initBrands() {
        brands.addItem("select brand", "-1");
        brands.addChangeHandler((changeEvent) -> {
            announcementFormService.setModels(Long.valueOf(brands.getSelectedValue()));
            models.setVisible(true);
            if (Objects.equals(brands.getValue(0), "-1")) brands.removeItem(0);
        });
        announcementFormService.setBrands();
    }

    private void initModels() {
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

    private void sendAnnouncement() {
        announcementFormService.sendAnnouncement(buildAnnouncement());
        parentView.showMainPage();

    }

    private AnnouncementResponse buildAnnouncement() {
        VehicleBrand brand = new VehicleBrand();
        brand.setVehicleBrandId(Long.valueOf(brands.getSelectedValue()));

        VehicleModel model = new VehicleModel();
        model.setVehicleModelId(Long.valueOf(models.getSelectedValue()));
        model.setVehicleBrand(brand);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel(model);
        vehicle.setColor(colorTextBox.getText());
        vehicle.setMileage(mileageIntBox.getValue());
        vehicle.setReleaseYear(releaseYearIntBox.getValue());

        AnnouncementResponse announcementResponse = new AnnouncementResponse();
        announcementResponse.setVehicle(vehicle);
        announcementResponse.setPrice(priceDoubleBox.getValue().floatValue());
        announcementResponse.setComment(commentTextArea.getText());
        return announcementResponse;
    }

    interface AnnouncementFormUiBinder extends UiBinder<VerticalPanel, AnnouncementFormView> {
    }

}
