package com.jabber.adapters;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;

/**
 * Created by rowantan on 10/6/14.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter implements OnPageChangeListener {

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
	public CharSequence getPageTitle(int position) {

		if (position == DETAIL_TAB) {
			return "Description";
		} else {
			return "Comments";
		}

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

}
