package com.android.benben.retrofitrxjava.site.presenter;


import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;

/**
 * Time      2017/4/12 11:07 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface ISitePresenter {
    /**
     * 查询
     * @param text
     * @param siteActivity
     */
    void inQuire(String text, BaseActivity siteActivity);

    /**
     * 查询成功
     * @param t
     */
    void quireSuccess(BaseEntity<PmovieBean> t);

    /**
     * 查询失败
     * @param e
     * @param isNetWorkError
     */
    void quireFail(Throwable e, boolean isNetWorkError);
}
