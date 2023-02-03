package com.GWTApp.client.presenters;

import com.GWTApp.model.UserRequest;
import com.google.gwt.user.client.ui.Panel;
import lombok.Data;

@Data
public class UserRequestPresenter implements Presenter {

    private UserRequest userRequest;
    private DisplayUserRequest view;

    public UserRequestPresenter(UserRequest userRequest, DisplayUserRequest view) {
        this.userRequest = userRequest;
        this.view = view;
        bind();
    }



    @Override
    public void bind() {
        view.setPresenter(this);
        view.clear();
        view.setUser(userRequest);

    }

    @Override
    public void go(Panel panel) {
        panel.add(view.asWidget());
    }

    public void showUser() {
        view.setUser(userRequest);
    }
}
