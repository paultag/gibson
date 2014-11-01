package bike.shed.gibson.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Place;
import bike.shed.gibson.models.Stay;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.tasks.APITask;

public class TripsActivity extends Activity implements APITask.APITaskHandler<Place> {

    class PlaceTask extends APITask<Place> {
        public PlaceTask(APITaskHandler<Place> callback) {super(callback);}

        @Override
        protected Place getData(TravelAPI travelClient, String el) {
            return travelClient.place(el);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        new PlaceTask(this).execute("paultag");
    }

    @Override
    public void handle(Place data) {
        ImageView imageView = (ImageView) this.findViewById(R.id.activity_trips_photo);
        Picasso.with(this).load(data.photo).into(imageView);
    }
}
