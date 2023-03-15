package com.GWTApp.client.components.mainPage;

import com.GWTApp.client.GWTApp;
import com.GWTApp.client.components.announcementForm.AnnouncementFormView;
import com.GWTApp.client.components.announcementList.AnnouncementListView;
import com.GWTApp.client.components.apierror.ApiErrorView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.fusesource.restygwt.client.Method;
//import org.jboss.errai.ui.nav.client.local.Page;

public class MainPageView extends Composite {
    private static final MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    private final GWTApp parentView;
    @UiField
    FlexTable flexTable = new FlexTable();

    public MainPageView(GWTApp gwtApp) {
        this.parentView = gwtApp;
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void handleError(Method method) {
        ApiErrorView apiErrorView = new ApiErrorView();
        flexTable.setWidget(0, 0, apiErrorView);
        apiErrorView.show(method);
    }

    public void handleAuthError(Method method) {
        parentView.handleError(method);
    }


    public void showMainPage() {
        AnnouncementListView announcementListView = new AnnouncementListView(this);
        flexTable.setWidget(1, 0, announcementListView);

    }

    public void showAnnouncementForm() {
        AnnouncementFormView announcementFormView = new AnnouncementFormView(this);
        flexTable.setWidget(1, 0, announcementFormView);

    }

    interface MainViewUiBinder extends UiBinder<HTMLPanel, MainPageView> {
    }

}