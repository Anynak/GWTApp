package com.GWTApp.client.components.announcementList.AnnouncementSearchCriteria;

import com.GWTApp.client.components.announcementList.AnnouncementListView;
import com.GWTApp.model.PageCriteria;
import com.GWTApp.model.SearchAnnouncementCriteria;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;


public class AnnouncementSearchCriteriaView extends Composite {

    private static final AnnouncementSearchUiBinder ourUiBinder = GWT.create(AnnouncementSearchUiBinder.class);
    private final AnnouncementListView parentView;
    @UiField
    VerticalPanel mainPanel;

    @UiField
    DoubleBox minPriceDoubleBox;
    @UiField
    DoubleBox maxPriceDoubleBox;
    @UiField
    IntegerBox mileageMinIntBox;
    @UiField
    IntegerBox mileageMaxIntBox;
    @UiField
    IntegerBox releaseYearMinIntBox;
    @UiField
    IntegerBox releaseYearMaxIntBox;
    @UiField
    TextBox colorTextBox;
    @UiField
    TextBox brandNameTextBox;
    @UiField
    TextBox modelNameTextBox;

    @UiField
    Button submitBtn;


    public AnnouncementSearchCriteriaView(AnnouncementListView parentView) {
        this.parentView = parentView;
        initWidget(ourUiBinder.createAndBindUi(this));

        submitBtn.addClickHandler(clickEvent -> search());

    }

    public void search() {
        PageCriteria pageCriteria = new PageCriteria();
        SearchAnnouncementCriteria announcementCriteria = new SearchAnnouncementCriteria();
        announcementCriteria.setVehicleModelName(modelNameTextBox.getValue());
        announcementCriteria.setVehicleBrandName(brandNameTextBox.getValue());
        announcementCriteria.setMileageMax(mileageMaxIntBox.getValue());
        announcementCriteria.setMileageMin(mileageMinIntBox.getValue());
        if (minPriceDoubleBox.getValue() != null)
            announcementCriteria.setPriceMin(minPriceDoubleBox.getValue().floatValue());
        if (maxPriceDoubleBox.getValue() != null)
            announcementCriteria.setPriceMax(maxPriceDoubleBox.getValue().floatValue());
        announcementCriteria.setColor(colorTextBox.getValue());
        announcementCriteria.setReleaseYearMin(releaseYearMinIntBox.getValue());
        announcementCriteria.setReleaseYearMax(releaseYearMaxIntBox.getValue());
        parentView.findAnnouncements(pageCriteria, announcementCriteria);
    }

    public void handleError(Method method) {
        this.parentView.handleError(method);

    }

    interface AnnouncementSearchUiBinder extends UiBinder<VerticalPanel, AnnouncementSearchCriteriaView> {
    }


}