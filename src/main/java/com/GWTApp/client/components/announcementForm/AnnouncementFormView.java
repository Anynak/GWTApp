package com.GWTApp.client.components.announcementForm;

import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.model.VehicleBrand;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.fusesource.restygwt.client.Method;

import java.util.List;

//https://stackoverflow.com/questions/22629632/gwt-listbox-onchangehandler
public class AnnouncementFormView extends Composite {
    @UiField
    VerticalPanel mainPanel;
    @UiField
    ListBox brands;
    @UiField
    ListBox models;

    private final ApiErrorView apiErrorView = new ApiErrorView();
    private final MainPageView mainPageView;

    public void showError(Method method) {
        this.apiErrorView.setMethod(method);
        this.apiErrorView.show();
    }

    interface AnnouncementFormUiBinder extends UiBinder<VerticalPanel, AnnouncementFormView> {
    }

    private static final AnnouncementFormUiBinder ourUiBinder = GWT.create(AnnouncementFormUiBinder.class);

    public AnnouncementFormView(MainPageView mainPageView) {
        this.mainPageView = mainPageView;

        initWidget(ourUiBinder.createAndBindUi(this));
        VehicleBrandService vehicleBrandService = new VehicleBrandService(this);
        vehicleBrandService.setBrands();


        mainPanel.add(apiErrorView);
    }

    public void setVehicleBrands(List<VehicleBrand> vehicleBrands) {
        for (VehicleBrand brand : vehicleBrands){
            brands.addItem(brand.getVehicleBrandName(), brand.getVehicleBrandId().toString());
        }
    }
}