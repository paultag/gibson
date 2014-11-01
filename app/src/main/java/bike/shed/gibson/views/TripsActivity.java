package bike.shed.gibson.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import bike.shed.gibson.R;
import bike.shed.gibson.tasks.TravelTask;

public class TripsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        new TravelTask().execute();
    }
}
