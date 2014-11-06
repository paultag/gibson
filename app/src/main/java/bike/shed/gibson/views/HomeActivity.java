package bike.shed.gibson.views;

/**
 *
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Place;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.support.TabbedActionBarActivity;
import bike.shed.gibson.tasks.APITask;
import bike.shed.gibson.tasks.LocationAPITask;
import bike.shed.gibson.views.fragments.StaysFragment;
import bike.shed.gibson.views.fragments.TripsFragment;

/**
 *
 */
public class HomeActivity extends TabbedActionBarActivity implements APITask.APITaskHandler<Place> {

    @Override
    public void addTabs() {
        this.addTab(new TripsFragment(), "Trips");
        this.addTab(new StaysFragment(), "Stays");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String gibsonUser = this.getString(R.string.gibson_user);
        new LocationAPITask(this).execute(gibsonUser);
    }

    @Override
    public void handle(Place data) {
        ImageView imageView = (ImageView) this.findViewById(R.id.activity_home_nav_header_image);
        TextView textView = (TextView) this.findViewById(R.id.activity_home_nav_header_text);

        textView.setText(data.name);
        Picasso.with(this).load(data.photo).into(imageView);
    }
}
