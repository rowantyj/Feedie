package com.jabber.topicline;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by rowantan on 10/6/14.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private final int DETAIL_TAB = 0;
    private final int COMMENT_TAB = 1;


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case DETAIL_TAB:
                //CALL DETAIL FRAGMENT INTO VIEW

                return new AboutDetailFragment();

            case COMMENT_TAB:
                //CALL COMMENT TAB FRAGMENT INTO VIEW

                return new CommentFragment();
        }


        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
