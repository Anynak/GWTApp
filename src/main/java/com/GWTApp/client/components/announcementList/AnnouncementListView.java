package com.GWTApp.client.components.announcementList;

import com.GWTApp.client.components.announcementList.AnnouncementSearchCriteria.AnnouncementSearchCriteriaView;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.model.AnnouncementRequest;
import com.GWTApp.model.PageCriteria;
import com.GWTApp.model.SearchAnnouncementCriteria;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;

import java.util.List;


public class AnnouncementListView extends Composite {

    private static final AnnouncementListUiBinder ourUiBinder = GWT.create(AnnouncementListUiBinder.class);
    private final MainPageView parentView;
    @UiField
    HorizontalPanel mainPanel;
    @UiField
    VerticalPanel listPanel;

    @UiField
    VerticalPanel list;

    @UiField
    Button addAnnouncementBtn;
    @UiField
    HTMLPanel search;

    AnnouncementListService announcementListService = new AnnouncementListService(this);


    public AnnouncementListView(MainPageView parentView) {

        this.parentView = parentView;
        initWidget(ourUiBinder.createAndBindUi(this));
        search.add(new AnnouncementSearchCriteriaView(this));
        addAnnouncementBtn.addClickHandler(clickEvent -> addAnnouncement());
        announcementListService.loadAnnouncements(new PageCriteria(), new SearchAnnouncementCriteria());

    }

    public void findAnnouncements(PageCriteria pageCriteria, SearchAnnouncementCriteria announcementCriteria) {
        announcementListService.loadAnnouncements(pageCriteria, announcementCriteria);
    }

    private void addAnnouncement() {
        parentView.showAnnouncementForm();
    }

    public void show(List<AnnouncementRequest> announcements) {
        list.clear();
        for (AnnouncementRequest ar : announcements) {
            Label label = new Label(ar.getVehicle().getVehicleModel().getVehicleBrand().getVehicleBrandName()
                    + " (" + ar.getVehicle().getVehicleModel().getVehicleModelName() + ")" + " - " + ar.getPrice() + " " + ar.getCurrency());
            label.setHeight("30px");
            list.add(label);
        }

    }


    public void handleError(Method method) {

        if (method.getResponse().getStatusCode() == 401) {
            parentView.handleAuthError(method);
        } else {
            ApiErrorView apiErrorView = new ApiErrorView();
            listPanel.add(apiErrorView);
            apiErrorView.show(method);
        }
    }

    interface AnnouncementListUiBinder extends UiBinder<HorizontalPanel, AnnouncementListView> {
    }


}