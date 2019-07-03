package com.vikas.learningandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
public class DemoFragmentAdapter extends FragmentStatePagerAdapter {
    public DemoFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        DemoFragment demoFragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message","Hello From Page"+i);
        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    @Override
    public int getCount() {
        return 100;
    }
}
