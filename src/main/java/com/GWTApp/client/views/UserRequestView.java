package com.GWTApp.client.views;


import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.GWT;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.ibm.icu.text.CaseMap;
import gwt.material.design.client.ui.MaterialLabel;

import java.util.List;

public class UserRequestView extends Composite  {

    @UiField
    CellTable<UserRequest> table;


    interface UserResponseViewUiBinder extends UiBinder<CellTable<UserRequest>, UserRequestView> {
    }
    private static final UserResponseViewUiBinder ourUiBinder = GWT.create(UserResponseViewUiBinder.class);

    public UserRequestView() {

        initWidget(ourUiBinder.createAndBindUi(this));
    }



    public void setUsers(List<UserRequest> users) {
        //CellTable<UserRequest> table = new CellTable<>();
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
    }


}