package com.GWTApp.client.repositories;

import com.GWTApp.model.VehicleBrand;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/vehicleBrands/v1")
public interface VehicleBrandRepository extends RestService {
    @GET
    void getVehicleBrands(
            @HeaderParam("Authorization") String token,
            MethodCallback<List<VehicleBrand>> vehicleBrands

    );
}
