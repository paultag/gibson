package bike.shed.gibson.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Stay;
import bike.shed.gibson.models.Trip;


public class TripsAdaptor extends GenericListAdaptor<Trip> {
    public TripsAdaptor(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout layout;

        if (view == null) {
            layout = (LinearLayout) LayoutInflater.from(this.context).inflate(
                    R.layout.trip_item, null);
        } else {
            layout = (LinearLayout) view;
        }

        Trip trip = (Trip) this.getItem(i);

        TextView name = (TextView) layout.findViewById(R.id.trip_item_name);
        TextView when = (TextView) layout.findViewById(R.id.trip_item_when);

        name.setText(trip.name);
        when.setText(trip.reason);

        layout.setTag(trip.id);
        return layout;
    }
}
