package com.GWTApp.client.components.announcementList;

import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.model.AnnouncementRequest;
import com.GWTApp.model.PageCriteria;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.fusesource.restygwt.client.Method;

import java.util.List;


public class AnnouncementListView extends Composite {

    private static final AnnouncementListUiBinder ourUiBinder = GWT.create(AnnouncementListUiBinder.class);
    private final MainPageView parentView;
    @UiField
    VerticalPanel mainPanel;

    public AnnouncementListView(MainPageView parentView) {
        this.parentView = parentView;
        initWidget(ourUiBinder.createAndBindUi(this));

        AnnouncementListService announcementListService = new AnnouncementListService(this);
        announcementListService.loadAnnouncements(new PageCriteria());
    }

    public void fillAnnouncementList(List<AnnouncementRequest> announcements) {

        for (AnnouncementRequest ar : announcements) {
            mainPanel.add(new Label(ar.getComment() + " - " + ar.getPrice() + " " + ar.getCurrency()));
        }
    }

    public void handleError(Method method) {
        this.parentView.handleError(method);

    }

    interface AnnouncementListUiBinder extends UiBinder<VerticalPanel, AnnouncementListView> {
    }


}