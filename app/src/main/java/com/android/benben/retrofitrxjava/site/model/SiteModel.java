package com.android.benben.retrofitrxjava.site.model;

import android.text.Editable;
import android.widget.TextView;

import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.APIFunction;
import com.android.benben.retrofitrxjava.http.RetrofitFactory;
import com.android.benben.retrofitrxjava.http.base.BaseObserver;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;
import com.android.benben.retrofitrxjava.http.config.HttpConfig;
import com.android.benben.retrofitrxjava.site.presenter.SitePresenter;

/**
 * Time      2017/4/12 11:12 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SiteModel implements ISiteModel {
    private SitePresenter mPresenter;

    public SiteModel(SitePresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void inQuire(String text, BaseActivity mView) {
        RetrofitFactory.getInstence().API()
                .getPmovie(text, HttpConfig.KEY)
                .compose(mView.<BaseEntity<PmovieBean>>setThread())
                .subscribe(new BaseObserver<PmovieBean>() {
                    @Override
                    protected void onSuccess(BaseEntity<PmovieBean> t) throws Exception {
                        mPresenter.quireSuccess(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mPresenter.quireFail(e,isNetWorkError);

                    }
                });

    }
}
