package com.GWTApp.client.service;

import com.GWTApp.model.UserRequest;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/api/user/search")
public interface UserService extends RestService {
    @GET
    void getUsers(@QueryParam("pageNumber") Integer pageNumber
            , @QueryParam("pageSize") Integer pageSize
            , @QueryParam("sortBy") String sortBy
            , @QueryParam("ASC") Boolean ASC
            , @QueryParam("country") String country
            , @QueryParam("city") String city
            , MethodCallback<List<UserRequest>> users
    );

}
