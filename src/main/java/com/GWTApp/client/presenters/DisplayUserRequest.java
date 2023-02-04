package com.GWTApp.client.presenters;

import com.GWTApp.model.UserRequest;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public interface DisplayUserRequest {
    void clear();

    void setUsers(List<UserRequest> userRequest);

    Widget asWidget();

    void setPresenter(UserRequestPresenter userRequestPresenter);
}
