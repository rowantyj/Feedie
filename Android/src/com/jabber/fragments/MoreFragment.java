package com.jabber.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.jabber.R;
import com.jabber.adapters.TermsFragment;

public class MoreFragment extends Fragment implements OnClickListener
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
		View rootView = inflater.inflate(R.layout.fragment_more, container,
				false);

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

		privacyPolicyBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				PrivacyPolicyFragment fragment = new PrivacyPolicyFragment();

				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
			}

		});

		termsBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				TermsFragment fragment = new TermsFragment();

				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();

			}
		});

		aboutUSBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				AboutUsFragment fragment = new AboutUsFragment();

				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
			}
		});

		reportBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				ReportFragment fragment = new ReportFragment();

				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
			}
		});

		return rootView;
	}

	@Override
	public void onClick(View v)
	{
		/*
		 * switch(v.getId()) { case R.id. }
		 */
	}

}
