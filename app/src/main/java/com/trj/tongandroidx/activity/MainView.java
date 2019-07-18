package com.trj.tongandroidx.activity;

import com.trj.tongandroidx.bean.TestBean;
import com.trj.tongandroidx.bean.resp.GoodsListModel;
import com.trjx.tbase.mvp.TView;

import java.util.List;

public interface MainView extends TView {

    void testSuccess(TestBean testBean);
    void test2Success(List<GoodsListModel> goodsList);
    void test3Success(GoodsListModel goodsListModel);

}
