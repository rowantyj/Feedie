package com.jabber.topicline;

import com.jabber.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by rowantan on 10/6/14.
 */
public class TopicDetailFragment extends Fragment {

    private ViewPager viewPager;
    private TabPagerAdapter mAdapter;

    public TopicDetailFragment() {


    }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
			{
			View rootView = inflater.inflate(R.layout.topic_detail_view, null, false);

      return rootView;
			}

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
			{
			super.onActivityCreated(savedInstanceState);
			
			mAdapter = new TabPagerAdapter(getFragmentManager() );
			
			
			
			
			
			
			}
		
		

    

}

