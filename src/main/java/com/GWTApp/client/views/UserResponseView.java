package com.GWTApp.client.views;

import com.GWTApp.client.presenters.UserRequestPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

public class UserResponseView extends Composite implements UserRequestPresenter.Display {
    @UiField
    Label name;

    private UserRequestPresenter presenter;
    @Override
    public void clear() {
        name.setText("");
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);

    }

    @Override
    public void setPresenter(UserRequestPresenter userRequestPresenter) {
        this.presenter = userRequestPresenter;
    }

    interface UserResponseViewUiBinder extends UiBinder<HTMLPanel, UserResponseView> {
    }

    private static UserResponseViewUiBinder ourUiBinder = GWT.create(UserResponseViewUiBinder.class);

    public UserResponseView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

}