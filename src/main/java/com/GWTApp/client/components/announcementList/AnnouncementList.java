package com.GWTApp.client.components.announcementList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

public class AnnouncementList {
    interface AnnouncementListUiBinder extends UiBinder<DivElement, AnnouncementList> {
    }

    private static AnnouncementListUiBinder ourUiBinder = GWT.create(AnnouncementListUiBinder.class);

    public AnnouncementList() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}