package com.jb.project.andfile.hearthstonedatabase.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {


     final static   List<RecyclerListFragment> mFragmentList = new ArrayList<>();
    private final   List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {

        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }


    public void addFragment(RecyclerListFragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        Log.d("ViewPagerAdapter", mFragmentList.toString());
    }

}
