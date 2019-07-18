package com.trjx.tbase.module.listmodule.xlistviewmodule;

import android.os.Handler;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;

import com.trjx.tbase.R;
import com.trjx.tbase.adapter.TBaseAdapter;
import com.trjx.tbase.module.listmodule.TBindDataListenter;
import com.trjx.tbase.module.listmodule.TListModule;
import com.trjx.tbase.module.listmodule.recyclerviewmodule.TRecyclerAdapter;
import com.trjx.tlibs.uils.Logger;

import java.util.List;

/**
 * @author tong
 * @date 2018/5/3 12:13
 * XListView 模块化
 * M 代表返回值的类型
 */
public abstract class TXListviewModule2<A extends TBaseAdapter> extends TListModule implements XListView.IXListViewListener {

    private ProgressBar mProgressBar;
    private XListView xListView;
    private Handler mHandler;

    private boolean openRefresh, openLoad;


    public TXListviewModule2() {
        super();
    }

    public void initView(View rootView, boolean openRefresh, boolean openLoad) {
        this.openRefresh = openRefresh;
        this.openLoad = openLoad;
        xListView = rootView.findViewById(R.id.xlistview);
        mProgressBar = rootView.findViewById(R.id.progressBar);
        isShowListLayout(false);
        initSet(xListView);
    }

    /**
     * 获取XListView 控件
     *
     * @return
     */
    public XListView getxListView() {
        return xListView;
    }

    private void initSet(XListView xListView) {
        xListView.setPullRefreshEnable(openRefresh);
        xListView.setPullLoadEnable(openLoad);
        xListView.setAutoLoadEnable(true);
        xListView.setXListViewListener(this);
        xListView.setRefreshTime(getTime());
        mHandler = new Handler();
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page = 1;
                if (null != listenter) {
                    listenter.getData(page);
                }
            }
        }, TIME_LR);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                if (null != listenter) {
                    listenter.getData(page);
                }
            }
        }, TIME_LR);
    }

    /**
     * 请求异常方法
     */
    @Override
    public void error() {
        super.error();
        if (page > 1) {
            page--;
            onLoad(1000);
        }
    }


    private void onLoad(int pageCount) {
        xListView.stopRefresh();
        xListView.stopLoadMore();
        xListView.setRefreshTime(getTime());
        if (pageCount > page) {
            xListView.setPullRefreshEnable(openRefresh);
            xListView.setPullLoadEnable(openLoad);
            xListView.setAutoLoadEnable(true);
        } else {
            xListView.setPullLoadEnable(false);
            xListView.setAutoLoadEnable(false);
        }
    }


    /**
     * 是否显示XListView
     *
     * @param isShow
     */
    @Override
    public void isShowListLayout(boolean isShow) {
        if (isShow) {
            mProgressBar.setVisibility(View.GONE);
            xListView.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
            xListView.setVisibility(View.GONE);
        }
    }

    private A adapter;

    /**
     * 绑定 XListView 的数据
     *
     * @param infoList          请求数据
     * @param totalList         整体的数据集合
     * @param bindDataListenter 绑定数据的接口
     */
    public void bindXListViewData(List infoList, final List totalList, final TBindDataListenter bindDataListenter) {
        if (getPage() == 1) {
            if (null == infoList || infoList.size() == 0) {
                onLoad(0);
                isShowDefLayout(true);
                return;
            }
            totalList.clear();
            isShowDefLayout(false);
            isShowListLayout(true);
            getxListView().setSelectionAfterHeaderView();
            getxListView().smoothScrollToPosition(0);
        }
        if (infoList != null) {
            totalList.addAll(infoList);
        }
        if (null != bindDataListenter) {
            if (adapter == null) {
                adapter = createAdapter();
            }else{
                adapter.notifyDataSetChanged();
            }
//            xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    bindDataListenter.onItemClick(totalList.get(position - 1), position - 1);
//                }
//            });
        } else {
            //提示用，可以忽略
            Logger.t("您还未创建或者关联适配器，请检查");
        }
        if (infoList == null || pageSize > infoList.size()) {
            onLoad(getPage());
        } else {
            onLoad(getPage() + 1);
        }
    }


    /**
     * 创建适配器
     */
    public abstract A createAdapter();

}
