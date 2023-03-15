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

    VerticalPanel listPanel = new VerticalPanel();

    AnnouncementListService announcementListService = new AnnouncementListService(this);


    public AnnouncementListView(MainPageView parentView) {

        this.parentView = parentView;

        initWidget(ourUiBinder.createAndBindUi(this));
        mainPanel.add(new AnnouncementSearchCriteriaView(this));
        mainPanel.add(listPanel);
        Button addAnnouncement = new Button();
        addAnnouncement.setText("ADD");
        mainPanel.add(addAnnouncement);
        addAnnouncement.addClickHandler(clickEvent -> addAnnouncement());
        announcementListService.loadAnnouncements(new PageCriteria(), new SearchAnnouncementCriteria());

    }

    public void findAnnouncements(PageCriteria pageCriteria, SearchAnnouncementCriteria announcementCriteria) {
        announcementListService.loadAnnouncements(pageCriteria, announcementCriteria);
    }

    private void addAnnouncement() {
        parentView.showAnnouncementForm();
    }

    public void show(List<AnnouncementRequest> announcements) {
        listPanel.setSpacing(20);
        listPanel.setBorderWidth(1);
        listPanel.setWidth("600px");
        listPanel.clear();
        listPanel.add(new Label("Announcements:"));
        for (AnnouncementRequest ar : announcements) {
            Label label = new Label(ar.getComment() + " - " + ar.getPrice() + " " + ar.getCurrency());
            label.setHeight("50px");
            listPanel.add(new Label(ar.getComment() + " - " + ar.getPrice() + " " + ar.getCurrency()));
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