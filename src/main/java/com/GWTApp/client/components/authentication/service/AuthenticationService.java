package com.GWTApp.client.components.authentication.service;

import com.GWTApp.client.components.authentication.repository.AuthenticationRepository;
import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.client.storage.entity.Token;
import com.GWTApp.client.components.authentication.view.LoginFormView;

import com.GWTApp.model.LoginEntity;

import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class AuthenticationService {

    private final LoginFormView loginFormView;

    public AuthenticationService(LoginFormView loginFormView) {
        this.loginFormView = loginFormView;
    }

    AuthenticationRepository repository = GWT.create(AuthenticationRepository.class);

    public void authUser(LoginEntity loginEntity) {
        repository.loginUser(loginEntity, new MethodCallback<Token>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                loginFormView.showError(method);
            }

            @Override
            public void onSuccess(Method method, Token token) {
                SecurityStorage.setAccessToken(token);
                loginFormView.onLoginSuccess();
            }
        });
    }

}
