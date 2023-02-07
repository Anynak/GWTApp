package com.GWTApp.client.views;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.service.AuthenticationService;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;

public class LoginFormView extends Composite {
    @UiField
    Label errorLabel;
    @UiField
    TextBox loginTextBox;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    Button loginBtn;
    GWTApp gwtApp;


    interface LoginFormUiBinder extends UiBinder<VerticalPanel, LoginFormView> {

    }

    private static final LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);


    private void toLoginUser() {
        AuthenticationService authenticationService = new AuthenticationService(this);
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogin(loginTextBox.getText());
        loginEntity.setPassword(passwordTextBox.getText());
        authenticationService.authUser(loginEntity);

    }

    public void showError(Method method) {
        errorLabel.setText(method.getResponse().getStatusText() + " " + method.getResponse().getStatusCode());

    }

    public void onLoginSuccess() {
        gwtApp.showMainPage();

    }

    public LoginFormView(GWTApp gwtApp) {
        this.gwtApp = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));

        loginBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                toLoginUser();

            }
        });

    }
}