package com.GWTApp.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class LoginForm extends Composite {
    @UiField
    TextBox loginTb;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    Button loginBtn;


    interface LoginFormUiBinder extends UiBinder<VerticalPanel, LoginForm> {
    }

    private static final LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);

    public LoginForm() {
        initWidget(ourUiBinder.createAndBindUi(this));

    }
}