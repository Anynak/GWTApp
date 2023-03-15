package com.GWTApp.client;

import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.authentication.LoginFormView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.client.components.registration.RegistrationFormView;
import com.GWTApp.client.storage.SecurityStorage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
//https://javastudy.ru/category/gwt/
//https://docs.jboss.org/errai/2.4.4.Final/errai/reference/html/sid-54493676.html
//https://www.tutorialspoint.com/gwt/gwt_deckpanel_widget.htm

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTApp implements EntryPoint {
    private final FlexTable flexTable = new FlexTable();
    //private final DeckPanel deckPanel = new DeckPanel();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        Defaults.setServiceRoot("http://127.0.0.1:8080/");
        //flexTable.setWidget(1,1,deckPanel);
        RootPanel.get("content").add(flexTable);
        if (SecurityStorage.getAccessToken() == null) {
            //showLoginPage();
            showRegisterPage();
        } else {
            showMainPage();
        }

        flexTable.setBorderWidth(1);
        //LoginFormView loginFormView = new LoginFormView(this);
        //RegistrationFormView registrationFormView = new RegistrationFormView(this);
        //MainPageView mainView = new MainPageView(this);

        //this.deckPanel.add(loginFormView);
        //this.deckPanel.add(registrationFormView);
        //this.deckPanel.add(mainView);

    }

    public void showLoginPage() {

        //this.deckPanel.showWidget(0);
        LoginFormView loginFormView = new LoginFormView(this);
        flexTable.setWidget(1, 0, loginFormView);
    }

    public void showRegisterPage() {
        //this.deckPanel.showWidget(1);
        RegistrationFormView registrationFormView = new RegistrationFormView(this);
        flexTable.setWidget(1, 0, registrationFormView);
    }

    public void showMainPage() {
        //this.deckPanel.showWidget(2);
        //
        MainPageView mainView = new MainPageView(this);
        flexTable.setWidget(1, 0, mainView);
        mainView.showMainPage();

    }

    public void handleError(Method method) {

        ApiErrorView apiErrorView = new ApiErrorView();

        if (method.getResponse().getStatusCode() == 401) {
            showLoginPage();
        }
        apiErrorView.setMethod(method);
        flexTable.setWidget(0, 0, apiErrorView);
        apiErrorView.show();
    }

}
