package com.GWTApp.client.service;

import com.GWTApp.client.views.UsersTableView;
import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class UsersTableService {
    public void fillTable(Integer pageNumber, Integer pageSize, String sortBy, Boolean ASC, String country, String city, UsersTableView usersTableView) {

        UserService userService = GWT.create(UserService.class);
        userService.getUsers(pageNumber, pageSize, sortBy, ASC, country, city, new MethodCallback<List<UserRequest>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {

            }

            @Override
            public void onSuccess(Method method, List<UserRequest> userRequests) {
                usersTableView.setUsers(userRequests);
            }
        });
    }
}
