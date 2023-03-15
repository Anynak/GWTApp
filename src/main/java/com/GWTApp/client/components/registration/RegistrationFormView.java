package com.GWTApp.client.components.registration;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.GWTApp.model.RegisterEntity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;

public class RegistrationFormView extends Composite {
    private static final RegistrationFormView.RegistrationFormUiBinder ourUiBinder = GWT.create(RegistrationFormView.RegistrationFormUiBinder.class);
    private final GWTApp parentView;
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
    @UiField
    Button signInBtn;
    @UiField
    VerticalPanel mainPanel;

    public RegistrationFormView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));

        registerBtn.addClickHandler(clickEvent -> registerUser());
        signInBtn.addClickHandler(clickEvent -> gwtApp.showLoginPage());


    }

    public void onRegistrationSuccess() {
        parentView.showLoginPage();

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

    public void handleError(Method method) {
        ApiErrorView apiErrorView = new ApiErrorView();
        mainPanel.add(apiErrorView);
        apiErrorView.show(method);
    }

    interface RegistrationFormUiBinder extends UiBinder<VerticalPanel, RegistrationFormView> {

    }
}
