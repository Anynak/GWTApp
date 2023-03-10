package com.GWTApp.client.components.announcementForm;

import com.GWTApp.model.AnnouncementRequest;
import com.GWTApp.model.AnnouncementResponse;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//https://stackoverflow.com/questions/13968261/required-queryparam-in-jax-rs-and-what-to-do-in-their-absence
@Path("/api/announcements/v1")
public interface AnnouncementRepository extends RestService {
    @POST
    void addAnnouncement(@HeaderParam("Authorization") String token,
                         AnnouncementResponse announcementResponse,
                         MethodCallback<AnnouncementRequest> methodCallback);

    @GET
    void getAnnouncements(@HeaderParam("Authorization") String token,
                         AnnouncementResponse announcementResponse,
                         MethodCallback<AnnouncementRequest> methodCallback);
}
