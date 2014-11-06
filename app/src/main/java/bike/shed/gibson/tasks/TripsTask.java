package bike.shed.gibson.tasks;

import java.util.List;

import bike.shed.gibson.models.Trip;
import bike.shed.gibson.services.TravelAPI;


public class TripsTask extends APITask<List<Trip>> {
    public TripsTask(APITaskHandler<List<Trip>> callback) {super(callback);}

    @Override
    protected List<Trip> getData(TravelAPI travelClient, String el) {
        return travelClient.trips(el);
    }
}