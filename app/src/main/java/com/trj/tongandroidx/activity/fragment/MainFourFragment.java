package com.trj.tongandroidx.activity.fragment;

import android.view.View;

import com.trj.tongandroidx.R;
import com.trj.tongandroidx.base.DemoMVPFragment;


public class MainFourFragment extends DemoMVPFragment<MainFourView,MainFourPresenter>
implements MainFourView{

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_four;
    }

    @Override
    protected void initFragmentView(View view) {

    }

    @Override
    protected MainFourPresenter initPersenter() {
        return new MainFourPresenter(this);
    }

}
