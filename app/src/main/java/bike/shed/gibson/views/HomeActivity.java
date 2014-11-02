package bike.shed.gibson.views;

/**
 *
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Place;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.tasks.APITask;

/**
 *
 */
public class HomeActivity extends Activity implements APITask.APITaskHandler<Place> {

    /**
     *
     */
    class LocationAPITask extends APITask<Place> {
        public LocationAPITask(APITaskHandler<Place> callback) {super(callback);}
        @Override
        protected Place getData(TravelAPI travelClient, String el) {
            return travelClient.place(el);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* Now, for the navbar, let's load up the header image by dispatching a LocationAPITask. */
        String gibsonUser = this.getString(R.string.gibson_user);
        new LocationAPITask(this).execute(gibsonUser);
    }

    /**
     *
     */
    @Override
    public void handle(Place data) {
        ImageView imageView = (ImageView) this.findViewById(R.id.activity_home_nav_header_image);
        Picasso.with(this).load(data.photo).into(imageView);
    }
}
