package com.GWTApp.client.components.mainPage;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.announcementForm.AnnouncementFormView;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.fusesource.restygwt.client.Method;

public class MainPageView extends Composite {
    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    private final GWTApp parentView;
    @UiField
    FlexTable flexTable = new FlexTable();

    private final ApiErrorView apiErrorView = new ApiErrorView();
    public void handleError(Method method) {
        if(method.getResponse().getStatusCode()==401){
            showLoginPage();
        }
        this.apiErrorView.setMethod(method);
        this.apiErrorView.show();
    }

    public MainPageView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void showMainPage() {
        AnnouncementFormView announcementFormView = new AnnouncementFormView(this);
        flexTable.setWidget(1, 0, announcementFormView);
        //UsersTableView usersTableView = new UsersTableView(this);
        //flexTable.setWidget(1, 0, usersTableView);
    }

    public void showLoginPage() {
        parentView.showLoginPage();

    }

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

}