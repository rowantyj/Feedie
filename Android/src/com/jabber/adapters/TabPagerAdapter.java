package com.jabber.adapters;

import java.util.List;

import com.jabber.fragments.AboutDetailFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;

/**
 * Created by rowantan on 10/6/14.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter implements ActionBar.TabListener,
		OnPageChangeListener {

	private final int DETAIL_TAB = 0;
	private final int COMMENT_TAB = 1;

	// private final ActionBar mActionBar;

	private List<Fragment> fList;

	public TabPagerAdapter(FragmentManager fm, List<Fragment> fList) {
		super(fm);
		this.fList = fList;

	}

	@Override
	public Fragment getItem(int i) {
		
		return fList.get(i);
		
		
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}
