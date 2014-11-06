package com.jabber.topicline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jabber.R;

/**
 * Created by rowantan on 10/6/14.
 */
public class AboutDetailFragment extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{

		View rootView = inflater.inflate(R.layout.fragment_detail_tab,
				container, false);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		// dedicate adapter to take over loading

		// DetailTabAdapter mAdapter = new DetailTabAdapter();

        //DetailTabAdapter mAdapter = new DetailTabAdapter(getActivity(), null);





    }

}
