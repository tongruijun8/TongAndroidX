package com.trj.tongandroidx.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trj.tongandroidx.R;
import com.trj.tongandroidx.test.RvActivity;
import com.trjx.tbase.activity.GuidePageActivity;

import java.util.List;

public class GuideActivity extends GuidePageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean setPageData(List<Object> imgList) {
        imgList.add(R.mipmap.page1);
        imgList.add(R.mipmap.page2);
        imgList.add(R.mipmap.page3);
        return true;
    }

    @Override
    protected void onClickSkipView() {
        skipActivity(RvActivity.class);
    }



}
