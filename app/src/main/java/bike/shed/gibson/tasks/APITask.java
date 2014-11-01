package bike.shed.gibson.tasks;

import android.os.AsyncTask;

import java.util.List;

import bike.shed.gibson.models.Stay;
import bike.shed.gibson.services.TravelAPI;
import bike.shed.gibson.services.TravelClient;

public abstract class APITask<A> extends AsyncTask<String, Void, A> {

    public interface APITaskHandler<A> {
        public void handle(A data);
    }

    protected APITaskHandler callback;

    public APITask(APITaskHandler<A> callback) {
        this.callback = callback;
    }

    abstract protected A getData(TravelAPI travelClient, String el);

    @Override
    protected A doInBackground(String... user) {
        TravelAPI travel = TravelClient.getService();
        return this.getData(travel, user[0]);
    }

    @Override
    protected void onPostExecute(A data) {
        super.onPostExecute(data);
        this.callback.handle(data);
    }
}

