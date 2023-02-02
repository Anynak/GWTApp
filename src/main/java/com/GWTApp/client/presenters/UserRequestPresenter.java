package com.GWTApp.client.presenters;

import com.GWTApp.model.UserRequest;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import lombok.Data;

@Data
public class UserRequestPresenter implements Presenter {

    private UserRequest userRequest;
    private Display view;

    public UserRequestPresenter(UserRequest userRequest, Display view) {
        this.userRequest = userRequest;
        this.view = view;
        bind();
    }

    public interface Display {
        void clear();

        void setName(String name);

        Widget asWidget();

        void setPresenter(UserRequestPresenter userRequestPresenter);
    }

    @Override
    public void bind() {
        view.setPresenter(this);
        view.clear();
        view.setName(userRequest.getName());

    }

    @Override
    public void go(Panel panel) {
        panel.add(view.asWidget());
    }

    public void showName() {
        view.setName(userRequest.getName());
    }
}
