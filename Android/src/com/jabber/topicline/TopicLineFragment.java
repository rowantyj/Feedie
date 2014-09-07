package com.jabber.topicline;

import java.util.ArrayList;
import java.util.List;

import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.jabber.R;

public class TopicLineFragment extends ListFragment implements OnItemClickListener
{

	String[]				menutitles;
	TypedArray				menuIcons;

	CustomAdapter			adapter;
	private List<RowItem>	rowItems;

	public TopicLineFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.list_fragment, null, false);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{

		super.onActivityCreated(savedInstanceState);

		menutitles = getResources().getStringArray(R.array.topics);
		menuIcons = getResources().obtainTypedArray(R.array.indicator);

		rowItems = new ArrayList<RowItem>();

		for (int i = 0; i < menutitles.length; i++)
		{
			RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
					i, -1));

			rowItems.add(items);
		}

		adapter = new CustomAdapter(getActivity(), rowItems);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{

		Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
				.show();

	}

}
