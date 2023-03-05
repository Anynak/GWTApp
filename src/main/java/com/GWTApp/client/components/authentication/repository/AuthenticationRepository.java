package com.GWTApp.client.components.authentication.repository;

import com.GWTApp.client.storage.entity.Token;
import com.GWTApp.model.LoginEntity;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/api/auth")
public interface AuthenticationRepository extends RestService {
    @POST
    @Path("/v1/login")
    void loginUser(LoginEntity loginEntity, MethodCallback<Token> methodCallback);
}
