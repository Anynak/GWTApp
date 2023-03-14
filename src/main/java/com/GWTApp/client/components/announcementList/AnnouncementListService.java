package com.GWTApp.client.components.announcementList;

import com.GWTApp.client.repositories.AnnouncementRepository;
import com.GWTApp.client.storage.SecurityStorage;
import com.GWTApp.model.AnnouncementRequest;
import com.GWTApp.model.PageCriteria;
import com.GWTApp.model.SearchAnnouncementCriteria;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class AnnouncementListService {
    private final AnnouncementRepository announcementRepository;

    private final AnnouncementListView announcementListView;

    public AnnouncementListService(AnnouncementListView announcementListView) {
        this.announcementListView = announcementListView;
        this.announcementRepository = GWT.create(AnnouncementRepository.class);
    }

    public void loadAnnouncements(PageCriteria pageCriteria, SearchAnnouncementCriteria announcementCriteria) {
        announcementRepository.getAnnouncements(SecurityStorage.getAccessToken(),
                pageCriteria.getPageNumber(),
                pageCriteria.getPageSize(),
                announcementCriteria.getPriceMin(),
                announcementCriteria.getPriceMax(),
                announcementCriteria.getMileageMin(),
                announcementCriteria.getMileageMax(),
                announcementCriteria.getReleaseYearMin(),
                announcementCriteria.getReleaseYearMax(),
                announcementCriteria.getColor(),
                announcementCriteria.getVehicleBrandName(),
                announcementCriteria.getVehicleModelName(),
                new MethodCallback<List<AnnouncementRequest>>() {

                    @Override
                    public void onSuccess(Method method, List<AnnouncementRequest> announcements) {
                        announcementListView.show(announcements);
                    }

                    @Override
                    public void onFailure(Method method, Throwable throwable) {

                        announcementListView.handleError(method);
                        try {
                            throw throwable;
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }

                    }

                });

    }
}
