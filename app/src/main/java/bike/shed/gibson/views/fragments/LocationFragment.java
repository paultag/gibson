package bike.shed.gibson.views.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Place;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.tasks.APITask;


public class LocationFragment extends Fragment implements APITask.APITaskHandler<Place> {

    class PlaceTask extends APITask<Place> {
        public PlaceTask(APITaskHandler<Place> callback) {super(callback);}

        @Override
        protected Place getData(TravelAPI travelClient, String el) {
            return travelClient.place(el);
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
        new PlaceTask(this).execute("paultag");
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(
                R.layout.fragment_location, container, false);
        this.layout = frameLayout;
        return frameLayout;
    }

    @Override
    public void handle(Place data) {
        ImageView imageView = (ImageView) this.layout.findViewById(R.id.fragment_location_photo);
        Picasso.with(this.layout.getContext()).load(data.photo).into(imageView);
    }
}
