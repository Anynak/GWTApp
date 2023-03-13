package com.GWTApp.client.components.mainPage;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.announcementList.AnnouncementListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.fusesource.restygwt.client.Method;
//import org.jboss.errai.ui.nav.client.local.Page;

//@Page(path="main")
public class MainPageView extends Composite {
    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    private final GWTApp parentView;
    @UiField
    FlexTable flexTable = new FlexTable();

    public MainPageView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));
        //showMainPage();
    }

    //private final ApiErrorView apiErrorView = new ApiErrorView();
    public void handleError(Method method) {
        parentView.handleError(method);
    }


    public void showMainPage() {
        //AnnouncementFormView announcementFormView = new AnnouncementFormView(this);
        AnnouncementListView announcementListView = new AnnouncementListView(this);
        flexTable.setWidget(1, 0, announcementListView);
        //UsersTableView usersTableView = new UsersTableView(this);
        //flexTable.setWidget(1, 0, usersTableView);
    }

    public void showLoginPage() {
        parentView.showLoginPage();

    }

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

}