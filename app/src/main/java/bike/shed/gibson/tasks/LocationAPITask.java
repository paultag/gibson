package bike.shed.gibson.tasks;

import bike.shed.gibson.models.Place;
import bike.shed.gibson.services.TravelAPI;


public class LocationAPITask extends APITask<Place> {
    public LocationAPITask(APITaskHandler<Place> callback) {super(callback);}
    @Override
    protected Place getData(TravelAPI travelClient, String el) {
        return travelClient.place(el);
    }
}
