package com.jabber.adapters;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class TopicExploreAdapter extends FragmentStatePagerAdapter implements
		OnPageChangeListener {

	private int pageCount = 0;
	private List<Fragment> fList;

	public TopicExploreAdapter(FragmentManager fm, List<Fragment> fList) {
		super(fm);
		this.fList = fList;
		pageCount = fList.size() + 1; // Double check here during runtime

	}
	
	

	@Override
	public Fragment getItem(int i) {
		
		
		return fList.get(i);
	}

	@Override
	public int getCount() {
		return pageCount;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {

	}

}
