package com.android.benben.retrofitrxjava.common;

import android.support.v4.app.FragmentActivity;

import com.android.benben.retrofitrxjava.http.bean.BaseView;
import com.android.benben.retrofitrxjava.widget.ProgressDialog;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Time      2017/4/10 13:33 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class BaseActivity extends FragmentActivity implements BaseView {
    private ProgressDialog mDialog;
    public <T> ObservableTransformer<T, T> setThread() {
        return  new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(io.reactivex.Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    @Override
    public void showDialog(String msg) {
        ProgressDialog.show(this, false, msg);
    }

    @Override
    public void showDialog(String title, String msg) {

    }

    @Override
    public void hindDialog() {
        ProgressDialog.cancle();

    }
}
