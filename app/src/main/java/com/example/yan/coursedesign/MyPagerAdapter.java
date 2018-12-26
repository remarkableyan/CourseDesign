package com.example.yan.coursedesign;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
    final List<Fragment> list = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        HomeFragment homeFragment = new HomeFragment();
        list.add(homeFragment);
        FriendsFragment friendsFragment = new FriendsFragment();
        list.add(friendsFragment);
        MeFragment meFragment = new MeFragment();
        list.add(meFragment);
    }
    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
