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
    @UiField
    FlexTable flexTable = new FlexTable();
    private final GWTApp gwtApp;

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);

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

}