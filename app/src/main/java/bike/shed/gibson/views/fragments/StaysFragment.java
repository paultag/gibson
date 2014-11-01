package bike.shed.gibson.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Place;
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

    protected FrameLayout layout;

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
        new StaysTask(this).execute("paultag");
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(
                R.layout.fragment_location, container, false);
        this.layout = frameLayout;
        return frameLayout;
    }

    @Override
    public void handle(List<Stay> data) {
        for (Stay stay : data) {
            Log.w("paultag", stay.lodging.name);
        }
    }
}
