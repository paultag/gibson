package bike.shed.gibson.support;

/*
 * This file is a part of Open Civic Data.
 *
 * Copyright (c) Sunlight Foundation, 2014 under the terms and conditions
 * of the BSD-3 license in the LICENSE file contained in this source
 * distribution.
 *
 * Contributors:
 * - Paul R. Tagliamonte <paultag@sunlightfoundation.com>
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import bike.shed.gibson.R;

/**
 * TabbedActionBarActivity is a superclass for any Actions which are
 * composed of Tabbed views of Fragments.
 *
 * Subclasses override the addTabs method to populate the Activity.
 */
public abstract class TabbedActionBarActivity extends ActionBarActivity {

	protected TabListener tabListener;
	protected FragmentViewPager fragmentViewPager;
	protected ActionBar actionBar;
    protected ArrayList<String> tabNames;

	/**
	 * Add Tabs to the Activity. This should be overridden in any subclasses.
     *
     * It's very common to call `this.addTab(fragment, tabName);` in this
     * method repeatedly.
	 */
	public abstract void addTabs();

    /**
     * Add a tab to the activity that's filled with a Fragment
     * `fragment`, labeled by tabName.
     *
     * @param fragment Fragment to populate the Activity with.
     * @param tabName Label for the Tab.
     */
	protected void addTab(Fragment fragment, String tabName) {
		if (
			this.fragmentViewPager == null ||
			this.actionBar == null ||
		    this.tabListener == null
		) {
			throw new IllegalStateException("Attempted to addTab before onCreate");
		}

        this.tabNames.add(tabName);
		this.fragmentViewPager.addFragment(fragment);
		ActionBar.Tab tab = this.actionBar.newTab().setText(tabName);
		tab.setTabListener(this.tabListener);
		this.actionBar.addTab(tab);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ViewPager viewPager = (ViewPager) this.findViewById(R.id.activity_home_pager);
		/* OK. Basic stuff is here. Let's do the stuff we need to do now. */

        this.tabNames = new ArrayList<String>();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, this.tabNames);

        ListView lv  = (ListView) this.findViewById(R.id.activity_home_nav_list);
        lv.setAdapter(aa);

        final DrawerLayout dl = (DrawerLayout) this.findViewById(R.id.activity_home_drawer);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                getActionBar().setSelectedNavigationItem(position);
                dl.closeDrawer(GravityCompat.START);
            }
        });

		/* Firstly, let's set up the Tab follower. */
		viewPager.setOnPageChangeListener(
				new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						getActionBar().setSelectedNavigationItem(position);
					}
				}
		);

		/* Great. Now, let's add a Generic fragment adapter */
		this.fragmentViewPager = new FragmentViewPager(this.getSupportFragmentManager());
		viewPager.setAdapter(this.fragmentViewPager);

		/* And a listener to do the paging */
		TabListener tabListener = new TabListener(viewPager);
		this.tabListener = tabListener;

		this.actionBar = this.getSupportActionBar();
		this.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        this.actionBar.setDisplayShowHomeEnabled(false);
        this.actionBar.setDisplayShowTitleEnabled(false); /* I want the space */

		this.addTabs();
    }

}
