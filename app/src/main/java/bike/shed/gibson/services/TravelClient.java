package bike.shed.gibson.services;

import java.util.List;

import bike.shed.gibson.models.Trip;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

public class TravelClient {
    private static final String API_URL = "http://travel.pault.ag/api/v1";

    public static TravelAPI getService() {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        return restAdapter.create(TravelAPI.class);
    }
}