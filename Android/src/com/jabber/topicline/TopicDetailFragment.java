package com.jabber.topicline;

<<<<<<< HEAD
import com.jabber.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
=======
import android.support.v4.app.FragmentActivity;
>>>>>>> FETCH_HEAD
import android.support.v4.view.ViewPager;


/**
 * Created by rowantan on 10/6/14.
 */
public class TopicDetailFragment extends FragmentActivity {

    private ViewPager viewPager;
    private TabPagerAdapter mAdapter;

    public TopicDetailFragment() {


    }

<<<<<<< HEAD
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
		
		

    
=======
>>>>>>> FETCH_HEAD

}

