package com.jabber.topicline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.jabber.R;

public class MoreFragment extends Fragment
{

	Button	editProfileBtn, privacyPolicyBtn, termsBtn, aboutUSBtn, logOutBtn,
			reportBtn;

	public MoreFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_more, null, false);

		editProfileBtn = (Button) rootView.findViewById(R.id.edit_profile_btn);
		privacyPolicyBtn = (Button) rootView
				.findViewById(R.id.privacy_policy_btn);
		termsBtn = (Button) rootView.findViewById(R.id.terms_of_service_btn);
		aboutUSBtn = (Button) rootView.findViewById(R.id.about_us_btn);
		logOutBtn = (Button) rootView.findViewById(R.id.logout_btn);
		reportBtn = (Button) rootView.findViewById(R.id.report_btn);
		
		final FragmentManager fragmentManager = getFragmentManager();
		
		editProfileBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				EditProfileFragment fragment = new EditProfileFragment();
				
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
			}
		});

		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		

		

	}

}
