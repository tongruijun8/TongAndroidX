package com.trjx.tbase.module.listmodule;

import android.view.View;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/6/12 15:47
 */
public interface TListListenter {
    /**
     * 异常页面点击事件：1.可以处理数据异常的页面；2.还可以处理网络异常的页面
     */
    void exceptionPageClickEvent();



    /**
     * 获取列表数据
     */
    void getData(int page);


//    /**
//     * 绑定数据
//     * @param listData
//     */
//    void bindListData(List<B> listData);

//    void onClickListenter(View view, int position, B b);


}
