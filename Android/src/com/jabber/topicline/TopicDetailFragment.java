package com.jabber.topicline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jabber.R;

public class TopicDetailFragment extends Fragment {

    private ViewPager viewPager;
    private TabPagerAdapter mAdapter;

    public TopicDetailFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.topic_detail_view, null, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.tabPager);
        mAdapter = new TabPagerAdapter(getFragmentManager());

        viewPager.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
