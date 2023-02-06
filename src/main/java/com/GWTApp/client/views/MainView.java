package com.GWTApp.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {
    @UiField
    FlexTable flexTable = new FlexTable();
    private LoginForm loginForm;
    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainView> {
    }

    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);

    public MainView() {
        initWidget(ourUiBinder.createAndBindUi(this));

    }

    public void removeForm(){
        flexTable.removeCell(1,0);
    }
    public void showForm(){
        loginForm = new LoginForm(this);
        flexTable.setWidget(1, 0, loginForm);
    }
}