package com.GWTApp.client;

import com.GWTApp.client.service.UsersTableService;
import com.GWTApp.client.views.LoginForm;
import com.GWTApp.client.views.MainView;
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
    //private final MainView mainView = new MainView();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        MainView mainView = new MainView();
        flexTable.setWidget(1,0,mainView);
        mainView.showForm();
        RootPanel.get("content").add(mainView);

        flexTable.setWidget(2, 0, usersTableView);
        Defaults.setServiceRoot("http://127.0.0.1:8080/");
        UsersTableService tableService = new UsersTableService();
        tableService.fillTable(1, 10, "name", true, "", "", usersTableView);
        RootPanel.get("content").add(flexTable);




    }
    public void removeForm(){
        //flexTable.removeCell(1,0);
    }

}
