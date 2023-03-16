package com.GWTApp.client.components.mainPage;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.announcementList.AnnouncementListView;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.usersList.UsersTableView;
import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.client.storage.entity.AuthDetails;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TabPanel;
import org.fusesource.restygwt.client.Method;
//import org.jboss.errai.ui.nav.client.local.Page;

public class MainPageView extends Composite {
    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    private final GWTApp parentView;
    @UiField
    FlexTable flexTable = new FlexTable();

    @UiField
    TabPanel tabPanel;

    public MainPageView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));

        AnnouncementListView announcementListView = new AnnouncementListView(this);
        tabPanel.add(announcementListView, "announcements |");
        tabPanel.selectTab(0);

        AuthDetails authDetails = SecurityStorage.getAuthDetails();
        if (authDetails != null && authDetails.isAdmin()) {
            UsersTableView usersTableView = new UsersTableView(this);
            tabPanel.add(usersTableView, "| users");
        }

    }

    public void handleError(Method method) {
        ApiErrorView apiErrorView = new ApiErrorView();
        flexTable.setWidget(0, 0, apiErrorView);
        apiErrorView.show(method);
    }

    public void handleAuthError(Method method) {
        parentView.handleError(method);
    }


    public void showAnnouncementForm() {
        parentView.showAnnouncementForm();

    }

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

}