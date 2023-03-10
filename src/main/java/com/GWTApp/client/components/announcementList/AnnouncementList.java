package com.GWTApp.client.components.announcementList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;


public class AnnouncementList extends Composite {
    interface AnnouncementListUiBinder extends UiBinder<HTMLPanel, AnnouncementList> {
    }

    private static AnnouncementListUiBinder ourUiBinder = GWT.create(AnnouncementListUiBinder.class);

    public AnnouncementList() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}