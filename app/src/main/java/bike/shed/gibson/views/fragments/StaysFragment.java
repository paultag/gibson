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
import bike.shed.gibson.models.Stay;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.tasks.APITask;


public class StaysFragment extends Fragment implements APITask.APITaskHandler<List<Stay>> {

    class StaysTask extends APITask<List<Stay>> {
        public StaysTask(APITaskHandler<List<Stay>> callback) {super(callback);}

        @Override
        protected List<Stay> getData(TravelAPI travelClient, String el) {
            return travelClient.stays(el);
        }
    }

    protected ListView layout;
    protected StaysAdaptor staysAdaptor;

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
                R.layout.fragment_stays, container, false);

        this.layout = (ListView) frameLayout.findViewById(R.id.fragment_stays_list);

        StaysAdaptor staysAdaptor = new StaysAdaptor(this.layout.getContext());
        this.layout.setAdapter(staysAdaptor);
        this.staysAdaptor = staysAdaptor;

        new StaysTask(this).execute("paultag");
        return frameLayout;
    }

    @Override
    public void handle(List<Stay> data) {
        this.staysAdaptor.add(data.iterator());
    }
}
