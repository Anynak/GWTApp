package com.GWTApp.client.views;


import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.ListDataProvider;
import org.fusesource.restygwt.client.Method;

import java.util.List;

public class UsersTableView extends Composite {

    @UiField
    FlexTable flexTable = new FlexTable();

    MainPageView mainPageView;

    interface UserResponseViewUiBinder extends UiBinder<HTMLPanel, UsersTableView> {
    }

    private static final UserResponseViewUiBinder ourUiBinder = GWT.create(UserResponseViewUiBinder.class);

    public UsersTableView(MainPageView mainPageView) {
        this.mainPageView = mainPageView;
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    public void showLoginPage(Method method) {
        mainPageView.showLoginPage();
        //Label error = new Label(method.getResponse().getStatusText() + " " + method.getResponse().getStatusCode());
        //flexTable.setWidget(1, 1, error);
    }

    public void setUsers(List<UserRequest> users) {
        CellTable<UserRequest> table = new CellTable<>();

        TextColumn<UserRequest> nameCol = new TextColumn<UserRequest>() {
            @Override
            public String getValue(UserRequest userRequest) {
                return userRequest.getName();
            }
        };
        TextColumn<UserRequest> emailCol = new TextColumn<UserRequest>() {
            @Override
            public String getValue(UserRequest userRequest) {
                return userRequest.getEmail();
            }
        };
        TextColumn<UserRequest> phoneCol = new TextColumn<UserRequest>() {
            @Override
            public String getValue(UserRequest userRequest) {
                return userRequest.getPhone();
            }
        };
        TextColumn<UserRequest> locationCol = new TextColumn<UserRequest>() {
            @Override
            public String getValue(UserRequest userRequest) {
                return userRequest.getCountry() + " " + userRequest.getCity();
            }
        };
        //nameCol.setSortable(true);
        table.addColumn(locationCol, "location");
        table.addColumn(emailCol, "email");
        table.addColumn(phoneCol, "phone number");
        table.addColumn(nameCol, "name");
        table.setTitle("Users");

        ListDataProvider<UserRequest> dataProvider = new ListDataProvider<>();

        dataProvider.addDataDisplay(table);
        dataProvider.setList(users);
        flexTable.setWidget(1, 1, table);
    }


}