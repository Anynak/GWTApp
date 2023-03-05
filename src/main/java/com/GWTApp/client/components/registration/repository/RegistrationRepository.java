package com.GWTApp.client.components.registration.repository;

import com.GWTApp.model.RegisterEntity;
import com.GWTApp.model.UserResponse;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/api/auth")
public interface RegistrationRepository extends RestService {

    @POST
    @Path("/v1/register")
    void registerUser(RegisterEntity registerEntity, MethodCallback<UserResponse> methodCallback);

}
