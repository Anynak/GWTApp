package com.GWTApp.client.service;

import com.GWTApp.client.storage.Security;
import com.GWTApp.client.storage.entity.Token;
import com.GWTApp.model.LoginEntity;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class AuthenticationService {
    AuthenticationRepository repository = GWT.create(AuthenticationRepository.class);
    public void authUser(LoginEntity loginEntity){
        repository.loginUser(loginEntity, new MethodCallback<Token>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {

            }

            @Override
            public void onSuccess(Method method, Token token) {
                Security security = new Security();
                security.setAccessToken(token);
            }
        });
    }


}
