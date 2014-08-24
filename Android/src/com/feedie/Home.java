package com.feedie;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Home extends Activity
{

	private String[]				drawerItemTitles;
	private DrawerLayout			drawerLayout;
	private ListView				drawerList;

	private CharSequence			drawerTitle;
	private CharSequence			title;
	private ActionBarDrawerToggle	drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		title = drawerTitle = getTitle();
		drawerItemTitles = getResources().getStringArray(
				R.array.Drawer_Item_List);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.left_drawer);

		drawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, drawerItemTitles));

		drawerList.setOnItemClickListener(new DrawerItemClickListener());



		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close)
		{
			//Called when a drawer has settled in a completely closed state
			@Override
			public void onDrawerClosed(View view)
			{
				//super.onDrawerClosed(view);
				getActionBar().setTitle(title);
				invalidateOptionsMenu(); // creates call to onPrepareOptionMenu()
			}

			//Called when a drawer has settled in a completely open state
			@Override
			public void onDrawerOpened(View drawerView)
			{
				//super.onDrawerOpened(drawerView);
				getActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();
			}
		};

		drawerLayout.setDrawerListener(drawerToggle);

		if (savedInstanceState == null)
		{
            selectItem(0);
        }

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);

		//Sync the toggle state after onRestoreInstanceState has occurred
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

	//Called whenever we call invalidateOptionMenu()
	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		//If the nav drawer is open, hide action items related to the content view
		boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
		menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//Pass the event to ActionBarDrawerToggle, if it returns true, then i has handled the app icon touch event
		if(drawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Custom listener for drawer item
	class DrawerItemClickListener implements ListView.OnItemClickListener
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			selectItem(position);
		}

	}

	private void selectItem(int position)
	{
		// Create a new fragment
		Fragment fragment = new HomeFragment();
		Bundle args = new Bundle();
		args.putInt(HomeFragment.DRAWER_ITEM_NUMBER, position);
		fragment.setArguments(args);

		// Insert the fragment by replacing any existing fragment
		android.app.FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();

		// Highlight the selected item, update the title & close the drawer
		drawerList.setItemChecked(position, true);
		setTitle(drawerItemTitles[position]);
		drawerLayout.closeDrawer(drawerList);
	}

	@Override
	public void setTitle(CharSequence titleIn)
	{
		title = titleIn;
		getActionBar().setTitle(title);
	}

	/** Fragment that appears in the "content_frame", shows a planet */
	public static class HomeFragment extends Fragment
	{
		public static final String	DRAWER_ITEM_NUMBER	= "item_number";

		public HomeFragment()
		{
			// Empty constructor required for fragment subclasses
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(R.layout.fragment_home, container,
					false);
			int i = getArguments().getInt(DRAWER_ITEM_NUMBER);
			String drawer_item_title = getResources().getStringArray(
					R.array.Drawer_Item_List)[i];

			int imageId = getResources().getIdentifier(
					drawer_item_title.toLowerCase(Locale.getDefault()),
					"drawable", getActivity().getPackageName());
			((ImageView) rootView.findViewById(R.id.image))
					.setImageResource(imageId);
			getActivity().setTitle(drawer_item_title);
			return rootView;
		}
	}
}
