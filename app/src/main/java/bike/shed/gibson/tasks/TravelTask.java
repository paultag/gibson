package bike.shed.gibson.tasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import bike.shed.gibson.models.Trip;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.services.TravelClient;
import retrofit.RestAdapter;

public class TravelTask extends AsyncTask<String, Void, List<Trip>> {

    @Override
    protected List<Trip> doInBackground(String... uri) {
        TravelAPI travel = TravelClient.getService();
        return travel.trips("paultag");
    }

    @Override
    protected void onPostExecute(List<Trip> trips) {
        super.onPostExecute(trips);
        // Fetch and print a list of the contributors to this library.
        for (Trip trip : trips) {
            Log.w("paultag", trip.name + " (" + trip.reason + ")");
        }
    }
}

