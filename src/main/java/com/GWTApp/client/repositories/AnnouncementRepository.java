package com.GWTApp.client.repositories;

import com.GWTApp.model.AnnouncementRequest;
import com.GWTApp.model.AnnouncementResponse;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import java.util.List;

//https://stackoverflow.com/questions/13968261/required-queryparam-in-jax-rs-and-what-to-do-in-their-absence
@Path("/api/announcements/v1")
public interface AnnouncementRepository extends RestService {
    @POST
    void addAnnouncement(@HeaderParam("Authorization") String token,
                         AnnouncementResponse announcementResponse,
                         MethodCallback<AnnouncementRequest> methodCallback);

    @GET
    void getAnnouncements(@HeaderParam("Authorization") String token,
                          @QueryParam("pageNumber") Integer pageNumber,
                          @QueryParam("pageSize") Integer pageSize,
                          @QueryParam("priceMin") Float priceMin,
                          @QueryParam("priceMax") Float priceMax,
                          @QueryParam("mileageMin") Integer mileageMin,
                          @QueryParam("mileageMax") Integer mileageMax,
                          @QueryParam("releaseYearMin") Integer releaseYearMin,
                          @QueryParam("releaseYearMax") Integer releaseYearMax,
                          @QueryParam("color") String color,
                          @QueryParam("vehicleBrandName") String vehicleBrandName,
                          @QueryParam("vehicleModelName") String vehicleModelName,
                          MethodCallback<List<AnnouncementRequest>> methodCallback);
}
