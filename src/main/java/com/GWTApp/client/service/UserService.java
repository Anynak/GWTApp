package com.GWTApp.client.service;

import com.GWTApp.model.UserRequest;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/user/search?pageNumber=1&pageSize=10&sortBy=name&country=rb&city=Minsk")
public interface UserService extends RestService {
    @GET
    public void getUsers(MethodCallback<List<UserRequest>> users);

}
