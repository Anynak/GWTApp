package com.GWTApp.client.components.announcementForm;

import com.GWTApp.model.VehicleBrand;
import com.GWTApp.model.VehicleModel;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;
@Path("/api/vehicleModels/v1")
public interface VehicleModelRepository extends RestService {

    @GET
    void getVehicleModelsByBrand(
            @HeaderParam("Authorization") String token,
            @QueryParam("brandId") Long brandId,
            MethodCallback<List<VehicleModel>> vehicleBrands

    );
}
