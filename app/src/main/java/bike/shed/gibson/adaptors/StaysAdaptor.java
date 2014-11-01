package bike.shed.gibson.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import bike.shed.gibson.R;
import bike.shed.gibson.models.Stay;


public class StaysAdaptor extends GenericListAdaptor<Stay> {
    public StaysAdaptor(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout layout;

        if (view == null) {
            layout = (LinearLayout) LayoutInflater.from(this.context).inflate(
                    R.layout.stay_item, null);
        } else {
            layout = (LinearLayout) view;
        }

        Stay stay = (Stay) this.getItem(i);
        layout.setTag(stay.id);
        ((TextView) layout.findViewById(R.id.stay_item_name)).setText(stay.lodging.name);
        ((TextView) layout.findViewById(R.id.stay_item_place)).setText(stay.lodging.place.name);
        return layout;
    }
}
