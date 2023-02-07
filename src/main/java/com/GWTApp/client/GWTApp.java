package com.GWTApp.client;

import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.client.components.authentication.view.LoginFormView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTApp implements EntryPoint {
    private final FlexTable flexTable = new FlexTable();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        Defaults.setServiceRoot("http://127.0.0.1:8080/");
        RootPanel.get("content").add(flexTable);
        if (SecurityStorage.getAccessToken() == null) {
            showLoginPage();
        } else {
            showMainPage();
        }


    }

    public void showLoginPage() {

        LoginFormView loginFormView = new LoginFormView(this);
        flexTable.setWidget(1, 0, loginFormView);


    }

    public void showMainPage() {
        MainPageView mainView = new MainPageView(this);
        flexTable.setWidget(1, 0, mainView);
        mainView.showMainPage();

    }

}
