package com.GWTApp.client.components.authentication;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;

public class LoginFormView extends Composite {
    private static final LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);

    @UiField
    TextBox loginTextBox;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    Button loginBtn;

    @UiField
    Button registerBtn;
    @UiField
    VerticalPanel mainPanel;
    GWTApp parentView;

    private final ApiErrorView apiErrorView = new ApiErrorView();

    public LoginFormView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));

        loginBtn.addClickHandler(clickEvent -> toLoginUser());
        registerBtn.addClickHandler(clickEvent -> gwtApp.showRegisterPage());

        mainPanel.add(apiErrorView);

    }

    private void toLoginUser() {
        AuthenticationService authenticationService = new AuthenticationService(this);
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogin(loginTextBox.getText());
        loginEntity.setPassword(passwordTextBox.getText());
        authenticationService.authUser(loginEntity);

    }

    public void showError(Method method) {
        this.apiErrorView.setMethod(method);
        this.apiErrorView.show();
    }

    public void onLoginSuccess() {
        parentView.showMainPage();

    }

    interface LoginFormUiBinder extends UiBinder<VerticalPanel, LoginFormView> {

    }
}