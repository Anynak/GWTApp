package com.GWTApp.client.views;

import com.GWTApp.client.service.UsersTableService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.fusesource.restygwt.client.Defaults;

public class MainView extends Composite {
    @UiField
    FlexTable flexTable = new FlexTable();
    private LoginForm loginForm;
    private final UsersTableView usersTableView = new UsersTableView();

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainView> {
    }

    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);

    public MainView() {
        initWidget(ourUiBinder.createAndBindUi(this));

    }

    public void showMainPage() {

        Defaults.setServiceRoot("http://127.0.0.1:8080/");
        UsersTableService tableService = new UsersTableService();
        tableService.fillTable(1, 10, "name", true, "", "", usersTableView);
        flexTable.setWidget(1, 0, usersTableView);
    }

    public void showForm() {
        loginForm = new LoginForm(this);
        flexTable.setWidget(1, 0, loginForm);
    }
}