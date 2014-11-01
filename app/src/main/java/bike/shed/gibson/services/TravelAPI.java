package bike.shed.gibson.services;

import java.util.List;

import bike.shed.gibson.models.Place;
import bike.shed.gibson.models.Stay;
import bike.shed.gibson.models.Trip;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TravelAPI {
    @GET("/trips/{user}/")
    List<Trip> trips(
            @Path("user")
            String user
    );

    @GET("/stays/{user}/")
    List<Stay> stays(
            @Path("user")
            String user
    );

    @GET("/locate/{user}/")
    Place place(
            @Path("user")
            String user
    );
}
