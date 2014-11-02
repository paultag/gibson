package bike.shed.gibson.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

import bike.shed.gibson.R;
import bike.shed.gibson.adaptors.StaysAdaptor;
import bike.shed.gibson.adaptors.TripsAdaptor;
import bike.shed.gibson.models.Stay;
import bike.shed.gibson.models.Trip;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.tasks.APITask;


public class TripsFragment extends Fragment implements APITask.APITaskHandler<List<Trip>> {

    class TripsTask extends APITask<List<Trip>> {
        public TripsTask(APITaskHandler<List<Trip>> callback) {super(callback);}

        @Override
        protected List<Trip> getData(TravelAPI travelClient, String el) {
            return travelClient.trips(el);
        }
    }

    protected ListView layout;
    protected TripsAdaptor tripsAdaptor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(
                R.layout.fragment_trips, container, false);

        this.layout = (ListView) frameLayout.findViewById(R.id.fragment_trips_list);

        TripsAdaptor tripsAdaptor = new TripsAdaptor(this.layout.getContext());
        this.layout.setAdapter(tripsAdaptor);
        this.tripsAdaptor = tripsAdaptor;

        new TripsTask(this).execute("paultag");
        return frameLayout;
    }

    @Override
    public void handle(List<Trip> data) {
        this.tripsAdaptor.add(data.iterator());
    }
}
