package com.trj.tongandroidx.activity.fragment;

import android.view.View;

import com.trj.tongandroidx.R;
import com.trj.tongandroidx.base.DemoMVPFragment;


public class MainThreeFragment extends DemoMVPFragment<MainThreeView,MainThreePresenter>
implements MainThreeView{

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_three;
    }

    @Override
    protected void initFragmentView(View view) {

    }

    @Override
    protected MainThreePresenter initPersenter() {
        return new MainThreePresenter(this);
    }

}
