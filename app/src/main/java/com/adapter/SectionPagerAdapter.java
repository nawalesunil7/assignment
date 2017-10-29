package com.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentList = new ArrayList();
    ArrayList<String> Title = new ArrayList();


    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addfragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        Title.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Title.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
