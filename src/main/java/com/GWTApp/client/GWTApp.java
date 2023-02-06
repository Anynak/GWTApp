package com.GWTApp.client;

import com.GWTApp.client.views.MainView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTApp implements EntryPoint {
    private final FlexTable flexTable = new FlexTable();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        MainView mainView = new MainView();
        flexTable.setWidget(1,0,mainView);
        mainView.showForm();
        RootPanel.get("content").add(mainView);

    }

}
