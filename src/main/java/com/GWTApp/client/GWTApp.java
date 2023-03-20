package com.GWTApp.client;

import com.GWTApp.client.components.announcementForm.AnnouncementFormView;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.client.components.authentication.LoginFormView;
import com.GWTApp.client.components.mainPage.MainPageView;
import com.GWTApp.client.components.registration.RegistrationFormView;
import com.GWTApp.client.storage.SecurityStorage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
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

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        Defaults.setServiceRoot("http://127.0.0.1:8080/");
        RootPanel.get("content").add(flexTable);
        if (SecurityStorage.getAccessToken() == null) {
            showRegisterPage();
        } else {
            showMainPage();
        }

        flexTable.setBorderWidth(6);

    }

    private void drawComponent(Composite component) {
        flexTable.setWidget(1, 1, component);
    }

    private void drawError(Composite error) {
        flexTable.setWidget(0, 0, error);
    }

    public void showLoginPage() {
        LoginFormView loginFormView = new LoginFormView(this);
        drawComponent(loginFormView);
    }

    public void showRegisterPage() {
        RegistrationFormView registrationFormView = new RegistrationFormView(this);
        drawComponent(registrationFormView);
    }

    public void showMainPage() {
        MainPageView mainView = new MainPageView(this);
        drawComponent(mainView);

    }

    public void showAnnouncementForm() {
        AnnouncementFormView announcementFormView = new AnnouncementFormView(this);
        drawComponent(announcementFormView);
    }

    public void handleError(Method method) {
        ApiErrorView apiErrorView = new ApiErrorView();
        if (method.getResponse().getStatusCode() == 401) {
            showLoginPage();
        }
        drawError(apiErrorView);
        apiErrorView.show(method);
    }

}
