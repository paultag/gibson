package bike.shed.gibson.tasks;

import java.util.List;

import bike.shed.gibson.models.Stay;
import bike.shed.gibson.services.TravelAPI;


public class StaysTask extends APITask<List<Stay>> {
    public StaysTask(APITaskHandler<List<Stay>> callback) {super(callback);}

    @Override
    protected List<Stay> getData(TravelAPI travelClient, String el) {
        return travelClient.stays(el);
    }
}
