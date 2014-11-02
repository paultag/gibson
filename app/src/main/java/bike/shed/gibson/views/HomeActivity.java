package bike.shed.gibson.views;

/**
 *
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Place;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.support.TabbedActionBarActivity;
import bike.shed.gibson.tasks.APITask;
import bike.shed.gibson.views.fragments.StaysFragment;

/**
 *
 */
public class HomeActivity extends TabbedActionBarActivity implements APITask.APITaskHandler<Place> {

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
    public void addTabs() {
        this.addTab(new StaysFragment(), "Stays");
        this.addTab(new StaysFragment(), "Stays");
        this.addTab(new StaysFragment(), "Stays");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
