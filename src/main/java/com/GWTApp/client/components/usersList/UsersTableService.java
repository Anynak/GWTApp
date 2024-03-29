package com.GWTApp.client.components.usersList;

import com.GWTApp.client.repositories.UserRepository;
import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class UsersTableService {

    private final UsersTableView usersTableView;
    private final UserRepository userRepository;


    public UsersTableService(UsersTableView usersTableView) {
        this.usersTableView = usersTableView;
        this.userRepository = GWT.create(UserRepository.class);
    }

    public void fillTable(Integer pageNumber, Integer pageSize, String sortBy, Boolean ASC, String country, String city) {

        userRepository.getUsers(SecurityStorage.getAccessToken(), pageNumber, pageSize, sortBy, ASC, country, city, new MethodCallback<List<UserRequest>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                usersTableView.handleError(method);
            }

            @Override
            public void onSuccess(Method method, List<UserRequest> userRequests) {
                usersTableView.setUsers(userRequests);
            }
        });
    }
}
