package com.GWTApp.client.components.registration;

import com.GWTApp.model.RegisterEntity;
import com.GWTApp.model.UserResponse;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class RegistrationService {
    private final RegistrationFormView registrationFormView;
    RegistrationRepository repository = GWT.create(RegistrationRepository.class);

    public RegistrationService(RegistrationFormView registrationFormView) {
        this.registrationFormView = registrationFormView;
    }

    public void registerUser(RegisterEntity registerEntity) {
        repository.registerUser(registerEntity, new MethodCallback<UserResponse>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                registrationFormView.showError(method);
            }

            @Override
            public void onSuccess(Method method, UserResponse userResponse) {
                registrationFormView.onRegistrationSuccess();
            }
        });
    }
}
