package com.GWTApp.client;

import com.GWTApp.client.service.UsersTableService;
import com.GWTApp.client.views.LoginForm;
import com.GWTApp.client.views.UsersTableView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTApp implements EntryPoint {
    private final FlexTable flexTable = new FlexTable();
    private final UsersTableView usersTableView = new UsersTableView();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        LoginForm loginForm = new LoginForm();
        flexTable.setWidget(1, 0, loginForm);

        Defaults.setServiceRoot("http://127.0.0.1:8080/");
        UsersTableService tableService = new UsersTableService();
        tableService.fillTable(1, 10, "name", true, "", "", usersTableView);
        flexTable.setWidget(2, 0, usersTableView);

        RootPanel.get("content").add(flexTable);

    }

}
