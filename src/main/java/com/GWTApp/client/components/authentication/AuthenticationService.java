package com.GWTApp.client.components.authentication;


import com.GWTApp.client.repositories.AuthenticationRepository;
import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.client.storage.entity.AuthDetails;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class AuthenticationService {

    private final LoginFormView loginFormView;
    AuthenticationRepository repository = GWT.create(AuthenticationRepository.class);

    public AuthenticationService(LoginFormView loginFormView) {
        this.loginFormView = loginFormView;
    }

    public void authUser(LoginEntity loginEntity) {
        repository.loginUser(loginEntity, new MethodCallback<AuthDetails>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                loginFormView.handleError(method);
            }

            @Override
            public void onSuccess(Method method, AuthDetails authDetails) {
                SecurityStorage.saveAuthDetails(authDetails);
                loginFormView.onLoginSuccess();
            }
        });
    }

}
