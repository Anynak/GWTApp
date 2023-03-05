package com.GWTApp.client.components.registration.view;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.registration.service.RegistrationService;
import com.GWTApp.model.ApiError;
import com.GWTApp.model.RegisterEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import gwt.interop.utils.client.JSON;
import org.fusesource.restygwt.client.Method;

public class RegistrationFormView extends Composite {
    private static final RegistrationFormView.RegistrationFormUiBinder ourUiBinder = GWT.create(RegistrationFormView.RegistrationFormUiBinder.class);
    @UiField
    Label errorLabel;
    @UiField
    TextBox loginTextBox;
    @UiField
    TextBox nameTextBox;
    @UiField
    TextBox phoneTextBox;
    @UiField
    TextBox emailTextBox;
    @UiField
    TextBox countryTextBox;
    @UiField
    TextBox cityTextBox;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    PasswordTextBox repeatPasswordTextBox;
    @UiField
    Button registerBtn;
    GWTApp gwtApp;

    public RegistrationFormView(GWTApp gwtApp) {
        this.gwtApp = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));

        registerBtn.addClickHandler(clickEvent -> registerUser());
    }

    public void onRegistrationSuccess() {
        gwtApp.showLoginPage();

    }

    private void registerUser() {
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setLogin(loginTextBox.getText());
        registerEntity.setName(nameTextBox.getText());
        registerEntity.setEmail(emailTextBox.getText());
        registerEntity.setPhone(phoneTextBox.getText());
        registerEntity.setCountry(cityTextBox.getText());
        registerEntity.setCity(cityTextBox.getText());
        registerEntity.setPassword(passwordTextBox.getText());
        registerEntity.setRepeatPassword(repeatPasswordTextBox.getText());
        RegistrationService registrationService = new RegistrationService(this);
        registrationService.registerUser(registerEntity);

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

    interface RegistrationFormUiBinder extends UiBinder<VerticalPanel, RegistrationFormView> {

    }
}
