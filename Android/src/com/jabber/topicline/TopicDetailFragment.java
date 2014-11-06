package com.jabber.topicline;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jabber.R;

/**
 * Created by rowantan on 10/6/14.
 */
public class TopicDetailFragment extends FragmentActivity {

	private ViewPager viewPager;
	private TabPagerAdapter mAdapter;

	public TopicDetailFragment() {

	}

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		return super.onCreateView(name, context, attrs);
		
	}



}
