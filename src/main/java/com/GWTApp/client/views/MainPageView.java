package com.GWTApp.client.views;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.service.UsersTableService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;

public class MainPageView extends Composite {
    @UiField
    FlexTable flexTable = new FlexTable();
    GWTApp gwtApp;


    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);

    public MainPageView(GWTApp gwtApp) {
        this.gwtApp = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));


    }

    public void showMainPage() {
        UsersTableView usersTableView = new UsersTableView(this);
        UsersTableService tableService = new UsersTableService();
        tableService.fillTable(1, 10, "name", true, "", "", usersTableView);
        flexTable.setWidget(1, 0, usersTableView);
    }

    public void showLoginPage() {
        gwtApp.showLoginPage();

    }

}