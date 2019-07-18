package com.trj.tongandroidx.activity;

import com.trj.tongandroidx.R;
import com.trj.tongandroidx.activity.fragment.MainFourFragment;
import com.trj.tongandroidx.activity.fragment.MainOneFragment;
import com.trj.tongandroidx.activity.fragment.MainThreeFragment;
import com.trj.tongandroidx.activity.fragment.MainTwoFragment;
import com.trjx.tbase.activity.NavBottomActivity;

public class MainNavActivity extends NavBottomActivity {
    @Override
    protected boolean initSmoothScroll() {
        return false;
    }

    @Override
    protected void initFragmentData() {
        fragmentList.add(new MainOneFragment());
        fragmentList.add(new MainTwoFragment());
        fragmentList.add(new MainThreeFragment());
        fragmentList.add(new MainFourFragment());
    }

    @Override
    protected int initTabMenu() {
        return R.menu.navigation_main;
    }
}
