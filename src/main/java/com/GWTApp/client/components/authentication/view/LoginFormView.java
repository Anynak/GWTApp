package com.GWTApp.client.components.authentication.view;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.authentication.service.AuthenticationService;
import com.GWTApp.model.ApiError;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import gwt.interop.utils.client.JSON;
import org.fusesource.restygwt.client.Method;

public class LoginFormView extends Composite {
    private static final LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);
    @UiField
    Label errorLabel;
    @UiField
    TextBox loginTextBox;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    Button loginBtn;
    GWTApp gwtApp;

    public LoginFormView(GWTApp gwtApp) {
        this.gwtApp = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));

        loginBtn.addClickHandler(clickEvent -> toLoginUser());

    }

    private void toLoginUser() {
        AuthenticationService authenticationService = new AuthenticationService(this);
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogin(loginTextBox.getText());
        loginEntity.setPassword(passwordTextBox.getText());
        authenticationService.authUser(loginEntity);

    }

    public void showError(Method method) {


        String errorMessage = method.getResponse().getText();


        try {
            ApiError apiError = JSON.parse(errorMessage);
            errorLabel.setText(apiError.toString());

        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }


    }

    public void onLoginSuccess() {
        gwtApp.showMainPage();

    }

    interface LoginFormUiBinder extends UiBinder<VerticalPanel, LoginFormView> {

    }
}