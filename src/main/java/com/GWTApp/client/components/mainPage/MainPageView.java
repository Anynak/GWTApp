package com.GWTApp.client.components.mainPage;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.announcementList.AnnouncementListView;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.chat.Chat;
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

public class MainPageView extends Composite {
    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    private final GWTApp parentView;
    @UiField
    FlexTable flexTable = new FlexTable();

    public MainPageView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));


        chowTabPanel(createTabPanel());
        showChat();
    }

    public void handleError(Method method) {
        ApiErrorView apiErrorView = new ApiErrorView();
        flexTable.setWidget(0, 0, apiErrorView);
        apiErrorView.show(method);
    }

    private void showChat() {
        Chat chat = new Chat();
        flexTable.setWidget(1, 0, chat);
    }

    private void chowTabPanel(TabPanel tabPanel) {
        flexTable.setWidget(1, 1, tabPanel);
    }

    private TabPanel createTabPanel() {
        AnnouncementListView announcementListView = new AnnouncementListView(this);
        TabPanel tabPanel = new TabPanel();
        tabPanel.add(announcementListView, "announcements |");
        AuthDetails authDetails = SecurityStorage.getAuthDetails();
        if (authDetails != null && authDetails.isAdmin()) {
            UsersTableView usersTableView = new UsersTableView(this);
            tabPanel.add(usersTableView, "| users");
        }
        tabPanel.selectTab(0);
        return tabPanel;
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