package com.android.benben.retrofitrxjava.site.presenter;

import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;
import com.android.benben.retrofitrxjava.site.model.SiteModel;
import com.android.benben.retrofitrxjava.site.view.SiteActivity;

/**
 * Time      2017/4/12 11:12 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SitePresenter implements ISitePresenter {
    private SiteActivity mView;
    private SiteModel mModel;

    public SitePresenter( SiteActivity mView) {
        mModel = new SiteModel(this);
        this.mView = mView;
    }

    @Override
    public void inQuire(String text, BaseActivity siteActivity) {
        mModel.inQuire(text,siteActivity);

    }

    @Override
    public void quireSuccess(BaseEntity<PmovieBean> t) {
        mView.quireSuccess(t);

    }

    @Override
    public void quireFail(Throwable e, boolean isNetWorkError) {
        mView.quireFail(e, isNetWorkError);

    }
}
