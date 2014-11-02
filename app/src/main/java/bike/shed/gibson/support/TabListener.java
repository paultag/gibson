package bike.shed.gibson.support;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

public class TabListener implements ActionBar.TabListener {

    ViewPager viewPager;

    public TabListener(ViewPager viewPager) {
	    this.viewPager = viewPager;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        /* When we see that we've got a tab click, we'll
         * change up the ViewPager to match. */
        this.viewPager.setCurrentItem(tab.getPosition());
    }
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}

}
