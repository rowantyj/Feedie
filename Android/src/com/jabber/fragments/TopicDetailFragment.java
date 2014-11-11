package com.jabber.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jabber.R;
import com.jabber.adapters.TabPagerAdapter;

/**
 * Created by rowantan on 10/6/14.
 */
public class TopicDetailFragment extends Fragment {

	private ViewPager viewPager;
	private TabPagerAdapter mAdapter;

	public TopicDetailFragment() {

	}

	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.topic_detail_view, container,
				false);
		
		
		
		
		
		return rootView ;
	}

}
