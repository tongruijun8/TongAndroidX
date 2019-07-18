package com.trj.tongandroidx.activity.fragment;

import android.view.View;
import android.widget.TextView;

import com.trj.tongandroidx.R;
import com.trj.tongandroidx.activity.MainNavActivity;
import com.trj.tongandroidx.base.DemoMVPFragment;


public class MainOneFragment extends DemoMVPFragment<MainOneView,MainOnePresenter>
implements MainOneView{

    private TextView one;

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_one;
    }


    @Override
    protected void initFragmentView(View view) {

        one = view.findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainNavActivity) getActivity()).skipTab(2);
            }
        });

    }

    @Override
    protected MainOnePresenter initPersenter() {
        return new MainOnePresenter(this);
    }

}
