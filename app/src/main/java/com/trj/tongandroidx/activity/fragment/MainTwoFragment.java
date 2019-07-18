package com.trj.tongandroidx.activity.fragment;

import android.view.View;

import com.trj.tongandroidx.R;
import com.trj.tongandroidx.base.DemoMVPFragment;


public class MainTwoFragment extends DemoMVPFragment<MainTwoView,MainTwoPresenter>
implements MainTwoView{

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_two;
    }

    @Override
    protected void initFragmentView(View view) {

    }

    @Override
    protected MainTwoPresenter initPersenter() {
        return new MainTwoPresenter(this);
    }

}
