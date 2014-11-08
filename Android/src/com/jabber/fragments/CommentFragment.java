package com.jabber.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jabber.R;

/**
 * Created by rowantan on 10/6/14.
 */
public class CommentFragment extends Fragment implements View.OnClickListener
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{

		View rootView = inflater.inflate(R.layout.fragment_comment_tab,
				container, false);

		return rootView;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub

	}
}
