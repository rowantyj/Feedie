package com.jabber.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jabber.R;

/**
 * Created by rowantan on 10/6/14.
 */
public class AboutDetailFragment extends Fragment {

	private TextView topicDetailTV;

	public AboutDetailFragment() {
		super();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_detail_tab,
				container, false);
		topicDetailTV = (TextView) rootView.findViewById(R.id.topic_detailTV);

		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		
		
		 /*dedicate adapter to take over loading

		 DetailTabAdapter mAdapter = new DetailTabAdapter();
		 DetailTabAdapter mAdapter = new DetailTabAdapter(getActivity(),null);*/

	}
}
