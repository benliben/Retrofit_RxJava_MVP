package com.android.benben.retrofitrxjava.seek.presenter;


import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.seek.model.SeekModel;

import com.android.benben.retrofitrxjava.seek.view.SeekActivity;

/**
 * Time      2017/4/10 15:51 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SeekPresenter implements ISeekPresenter {
    private SeekActivity mView;
    private SeekModel mModel;

    public SeekPresenter(SeekActivity mView) {
        this.mView = mView;
        mModel = new SeekModel(this);
    }

    @Override
    public void inQuire(String mName, BaseActivity view) {
        mModel.inQuire(mName,view);

    }

    @Override
    public void quireSuccess(BaseEntity<ABean> t) {
        mView.quireSuccess(t);

    }

    @Override
    public void quireFail(Throwable e) {
        mView.quireFail(e);

    }
}
