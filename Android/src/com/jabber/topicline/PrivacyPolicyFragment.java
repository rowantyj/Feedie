package com.jabber.topicline;

import com.jabber.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PrivacyPolicyFragment extends Fragment
{

	public PrivacyPolicyFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_privacy_policy,
				container, false);

		return rootView;
	}

}
