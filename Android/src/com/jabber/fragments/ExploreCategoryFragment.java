package com.jabber.fragments;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.jabber.R;
import com.jabber.adapters.GridViewAdapter;

public class ExploreCategoryFragment extends Fragment
{

	private GridView			categoryGV;
	private ArrayList<String>	categoryList	= null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{

		View rootView = inflater.inflate(R.layout.fragment_explore_category,
				container, false);

		categoryGV = (GridView) rootView.findViewById(R.id.exploreCatGV);

		categoryList = new ArrayList<String>(Arrays.asList("People",
				"Products", "Places", "Issues", "Services", "Test Dummy"));

		GridViewAdapter mAdapter = new GridViewAdapter(getActivity(),
				categoryList);

		categoryGV.setAdapter(mAdapter);

		return rootView;
	}

}
