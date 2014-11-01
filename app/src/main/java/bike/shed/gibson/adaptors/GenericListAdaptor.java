package bike.shed.gibson.adaptors;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Iterator;

abstract public class GenericListAdaptor<E> extends BaseAdapter {
    protected ArrayList<E> arrayList;
    protected Context context;

    public GenericListAdaptor(Context context) {
        this.context = context;
        this.arrayList = new ArrayList<E>();
    }

    /**
     * Add object of parametrized type <E> to the internal
     * ArrayList.
     *
     * @param object object to add
     */
    public void add(E object) {
        this.arrayList.add(object);
        this.notifyDataSetChanged();
    }

    /**
     * Add objects of type <E> to the internal ArrayList.
     *
     * @param objs Iterator of objects of type <E> to add
     */
    public void add(Iterator<E> objs) {
        while (objs.hasNext()) {
            this.arrayList.add(objs.next());
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
