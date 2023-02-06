package com.GWTApp.client.views;

import com.GWTApp.client.service.AuthenticationService;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class LoginForm extends Composite {
    @UiField
    TextBox loginTextBox;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    Button loginBtn;

    AuthenticationService authenticationService = new AuthenticationService();

    interface LoginFormUiBinder extends UiBinder<VerticalPanel, LoginForm> {

    }

    private static final LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);


    private void toLoginUser() {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogin(loginTextBox.getText());
        loginEntity.setPassword(passwordTextBox.getText());
        authenticationService.authUser(loginEntity);
    }

    public LoginForm(MainView mainView) {
        initWidget(ourUiBinder.createAndBindUi(this));

        loginBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                toLoginUser();
                mainView.showMainPage();
            }
        });

    }
}