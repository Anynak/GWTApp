package com.GWTApp.client.presenters;

import com.GWTApp.client.presenters.UserRequestPresenter;
import com.GWTApp.model.UserRequest;
import com.google.gwt.user.client.ui.Widget;

public interface DisplayUserRequest {
    void clear();

    void setUser(UserRequest userRequest);

    Widget asWidget();

    void setPresenter(UserRequestPresenter userRequestPresenter);
}
