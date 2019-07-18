package com.trjx.tbase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;


import androidx.viewpager.widget.ViewPager;

import com.trjx.tbase.R;
import com.trjx.tbase.adapter.ImagePagerAdapter;
import com.trjx.tbase.module.titlemodule.TitleModule;
import com.trjx.tlibs.uils.GlideUtile;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看图片
 */
public class LookImagesActivity extends BaseActivity {

    /**
     * code值
     */
    public static final int resultCode_lookimg = 3000;

    private int index;
    private ArrayList<String> dataImg;

    private List<View> viewList = new ArrayList<>();
    private ViewPager viewPager;

    private ImagePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_images);
    }

    @Override
    protected void initView() {
        super.initView();
        titleModule.initTitle("", true);
        titleModule.initTitleMenu(TitleModule.MENU_TEXT,"删除");
        viewPager = findViewById(R.id.look_image_viewpager);

        Intent intent = getIntent();
        index = intent.getIntExtra("index", -1);
        dataImg = intent.getStringArrayListExtra("list");
        addImageViews();
        showImages();

    }

    private void addImageViews(){
        int len = dataImg.size();
        for (int i = 0; i < len; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_image, null);
            ImageView imageView = view.findViewById(R.id.item_image_imageview);
            GlideUtile.bindImageView(context,dataImg.get(i),imageView);
            viewList.add(view);
        }
    }

    private void showImages(){
        if (null != dataImg && dataImg.size() > 0) {
            if (index >= 0) {
                titleModule.setTitleLeftText((index+1) + "/" + dataImg.size());
                adapter = new ImagePagerAdapter(viewList);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(index,false);
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        titleModule.setTitleLeftText((position+1) + "/" + dataImg.size());
                        index = position;
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        }
    }

    @Override
    public void onClickBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("list", dataImg);
        setResult(resultCode_lookimg, intent);
        super.onClickBack(view);
    }

    @Override
    public void onClickRightText(View view) {
        super.onClickRightText(view);
        delectImag(index);
    }

    private void delectImag(int index) {
        dataImg.remove(index);
        viewList.remove(index);
        if(dataImg.size()>0){
            if(this.index == dataImg.size()){
                this.index--;
            }
            showImages();
        }else{
            backBefore();
        }
    }


    @Override
    protected boolean backBefore() {
        Intent intent = new Intent();
        intent.putExtra("list", dataImg);
        setResult(resultCode_lookimg, intent);
        finish();
        return false;
    }

}
