package com.android.benben.retrofitrxjava.seek.view;

import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;

/**
 * Time      2017/4/10 15:47 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface ISeekView {
    /**
     * 查询成功
     * @param t
     */
    void quireSuccess(BaseEntity<ABean> t);

    /**
     * 查询失败
     * @param e
     */
    void quireFail(Throwable e);
}
