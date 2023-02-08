package com.GWTApp.client.components.authentication;

import com.GWTApp.client.GWTApp;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
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

        loginBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                toLoginUser();

            }
        });

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
            JSONValue apiError = JSONParser.parseStrict(errorMessage);
            String mes = apiError.isObject().get("message").isString().toString();
            errorLabel.setText(mes);

        } catch (Exception e) {
            errorLabel.setText(errorMessage);
        }

    }

    public void onLoginSuccess() {
        gwtApp.showMainPage();

    }

    interface LoginFormUiBinder extends UiBinder<VerticalPanel, LoginFormView> {

    }
}