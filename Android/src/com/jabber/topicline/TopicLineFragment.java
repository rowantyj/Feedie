package com.jabber.topicline;

import java.util.ArrayList;

import android.app.ListFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jabber.R;

public class TopicLineFragment extends ListFragment implements
		OnItemClickListener
{

	String[]					titles;
	String[]					desc;
	String[]					iconsIndi;

	TopicLineAdapter			adapter;
	private ArrayList<Topic>	topicList;

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

		titles = getResources().getStringArray(R.array.topics);
		desc = getResources().getStringArray(R.array.desc);
		iconsIndi = getResources().getStringArray(R.array.indicator);

		if (savedInstanceState == null)
		{
			topicList = new ArrayList<Topic>();
			Toast.makeText(getActivity(), "NEW", Toast.LENGTH_SHORT).show();

			for (int i = 0; i < titles.length; i++)
			{
				Topic topic = new Topic(titles[i], desc[i], iconsIndi[2]
						.toString().substring(
								iconsIndi[2].toString().indexOf("green"),
								iconsIndi[2].toString().indexOf("green")
										+ "green".length()), "Test");
				topicList.add(topic);
			}
		}
		else
		{
			topicList = savedInstanceState.getParcelableArrayList("topicList");
			Toast.makeText(getActivity(), "OLD", Toast.LENGTH_SHORT).show();
		}

		adapter = new TopicLineAdapter(getActivity(), topicList);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{

		Toast.makeText(getActivity(), titles[position] + " marked as read",
				Toast.LENGTH_SHORT).show();
		// goes into TopicDetailView
		ImageView indicator = (ImageView) view.findViewById(R.id.indicatorIV);
		indicator.setImageResource(R.drawable.indicator_red);
		topicList.get(position).setIndicator("red");
		view.setAlpha((float) 0.5); // grey out the topic
		TextView title = (TextView) view.findViewById(R.id.titleTV);
		title.setTypeface(null, Typeface.NORMAL);

		TopicDetailFragment tdf = new TopicDetailFragment();

		android.app.FragmentTransaction ft = getFragmentManager()
				.beginTransaction();

	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList("topicList", topicList);
	}

}
