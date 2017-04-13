package com.android.benben.retrofitrxjava.seek.model;

import android.widget.Toast;

import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.RetrofitFactory;
import com.android.benben.retrofitrxjava.http.base.BaseObserver;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.config.HttpConfig;
import com.android.benben.retrofitrxjava.seek.presenter.SeekPresenter;

/**
 * Time      2017/4/10 15:50 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SeekModel implements ISeekModel {
    private SeekPresenter mPresenter;

    public SeekModel(SeekPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }


    @Override
    public void inQuire(String mName, BaseActivity view) {
        RetrofitFactory.getInstence().API()
                .getVideo(mName, HttpConfig.KEY)
                .compose(view.<BaseEntity<ABean>>setThread())
                .subscribe(new BaseObserver<ABean>() {
                    @Override
                    protected void onSuccess(BaseEntity<ABean> t) throws Exception {
                        mPresenter.quireSuccess(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mPresenter.quireFail(e);
                    }

                    @Override
                    protected void onCodeError(BaseEntity<ABean> t) throws Exception {
                        super.onCodeError(t);
                        Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
