package com.GWTApp.client.components.announcementList.AnnouncementSearchCriteria;

import com.GWTApp.client.components.announcementList.AnnouncementListView;
import com.GWTApp.model.PageCriteria;
import com.GWTApp.model.SearchAnnouncementCriteria;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.fusesource.restygwt.client.Method;


public class AnnouncementSearchCriteriaView extends Composite {

    private static final AnnouncementSearchUiBinder ourUiBinder = GWT.create(AnnouncementSearchUiBinder.class);
    private final AnnouncementListView parentView;
    @UiField
    VerticalPanel mainPanel;


    public AnnouncementSearchCriteriaView(AnnouncementListView parentView) {
        this.parentView = parentView;
        initWidget(ourUiBinder.createAndBindUi(this));

    }

    public void applySearchCriteria() {
        PageCriteria pageCriteria = new PageCriteria();
        SearchAnnouncementCriteria announcementCriteria = new SearchAnnouncementCriteria();

        parentView.findAnnouncements(pageCriteria, announcementCriteria);

    }

    public void handleError(Method method) {
        this.parentView.handleError(method);

    }

    interface AnnouncementSearchUiBinder extends UiBinder<VerticalPanel, AnnouncementSearchCriteriaView> {
    }


}