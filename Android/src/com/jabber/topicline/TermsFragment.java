package com.jabber.topicline;

import com.jabber.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TermsFragment extends Fragment
{

	public TermsFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_terms, container,
				false);

		return rootView;
	}

}
