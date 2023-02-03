package com.GWTApp.client.views;

import com.GWTApp.client.presenters.DisplayUserRequest;
import com.GWTApp.client.presenters.UserRequestPresenter;
import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.GWT;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import gwt.material.design.client.ui.MaterialLabel;

public class UserRequestView extends Composite implements DisplayUserRequest {
    @UiField
    MaterialLabel name;
    @UiField
    MaterialLabel phone;
    @UiField
    MaterialLabel email;
    @UiField
    MaterialLabel place;


    private UserRequestPresenter presenter;
    @Override
    public void clear() {
        name.setText("");
    }

    @Override
    public void setUser(UserRequest userRequest) {
        this.name.setText(userRequest.getName());
        this.phone.setText(userRequest.getPhone());
        this.email.setText(userRequest.getEmail());
        this.place.setText(userRequest.getCountry()+" "+userRequest.getCity());
    }

    @Override
    public void setPresenter(UserRequestPresenter userRequestPresenter) {
        this.presenter = userRequestPresenter;
    }

    interface UserResponseViewUiBinder extends UiBinder<HTMLPanel, UserRequestView> {
    }

    private static UserResponseViewUiBinder ourUiBinder = GWT.create(UserResponseViewUiBinder.class);


    public UserRequestView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

}