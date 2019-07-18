package com.trj.tongandroidx.base;

import com.trj.tongandroidx.http.DemoModel;
import com.trj.tongandroidx.http.RespState;
import com.trjx.tbase.activity.mvp.BaseMVPActivity;
import com.trjx.tbase.module.titlemodule.TitleModule;
import com.trjx.tbase.mvp.TModel;
import com.trjx.tbase.mvp.TPresenter;
import com.trjx.tbase.mvp.TView;
import com.trjx.tlibs.uils.Logger;

public abstract class DemoMVPActivity<V extends TView,P extends TPresenter<V,DemoModel>>
        extends BaseMVPActivity<V, DemoModel,P> {

    public TitleModule titleModule;

    @Override
    protected void initView() {
        titleModule = new TitleModule(context, rootView);
    }

    @Override
    public void tPostFail(int resultState) {
        super.tPostFail(resultState);

        if (resultState == RespState.POST_LOGIN_EXPRIES) {
//            跳转到登录页面重新登录
        } else if (resultState == RespState.POST_ERROR) {
//          请求异常
        } else if (resultState == RespState.POST_SIGN_ERROR) {
            Logger.t("秘钥错误");
        } else if (resultState == RespState.POST_PARAM_ERROR) {
            Logger.t("参数错误");
        } else if (resultState == RespState.POST_TIMEOUT) {
            Logger.t("请求超时");
        } else if (resultState == RespState.POST_REFRESH) {
            Logger.t("支付余额不足");
        }

    }

}
