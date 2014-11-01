package bike.shed.gibson.views;

/**
 *
 */

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

/**
 *
 */
public class TripsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
    }
}
