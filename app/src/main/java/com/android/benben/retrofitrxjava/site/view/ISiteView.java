package com.android.benben.retrofitrxjava.site.view;

import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;

/**
 * Time      2017/4/12 11:07 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface ISiteView {
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
