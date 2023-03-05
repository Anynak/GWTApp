package com.GWTApp.client.components.mainPage;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.usersList.UsersTableView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;

public class MainPageView extends Composite {
    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    private final GWTApp gwtApp;
    @UiField
    FlexTable flexTable = new FlexTable();

    public MainPageView(GWTApp gwtApp) {
        this.gwtApp = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void showMainPage() {
        UsersTableView usersTableView = new UsersTableView(this);
        flexTable.setWidget(1, 0, usersTableView);
    }

    public void showLoginPage() {
        gwtApp.showLoginPage();

    }

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

}