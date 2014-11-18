package com.jabber.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import com.jabber.R;
import com.jabber.adapters.TabPagerAdapter;

/**
 * Created by rowantan on 10/6/14.
 */
public class TopicDetailFragment extends FragmentActivity {

	private ViewPager viewPager;
	private PagerTabStrip mPagerTabStrip;
//	private ActionBar mActionBar;
	private TabPagerAdapter mAdapter;

	private List<Fragment> fList;

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		setContentView(R.layout.fragment_topic_detail_view);

		 mPagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);
		
		fList = new ArrayList<Fragment>();
		fList.add(new AboutDetailFragment());
		fList.add(new CommentFragment());
		mAdapter = new TabPagerAdapter(getSupportFragmentManager(), fList);
		viewPager = (ViewPager) findViewById(R.id.pager);

		viewPager.setAdapter(mAdapter);

	}

}
