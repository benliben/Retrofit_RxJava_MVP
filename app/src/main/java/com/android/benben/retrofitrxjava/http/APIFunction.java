package com.android.benben.retrofitrxjava.http;

import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;
import com.android.benben.retrofitrxjava.http.config.HttpConfig;


import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Time      2017/4/10 13:33 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface APIFunction {
    @POST(HttpConfig.MOVE_VIDEO)
    Observable<BaseEntity<ABean>> getVideo(@Query("q")String name,
                                           @Query("key")String key);

    @POST(HttpConfig.MOVE_PMOVIE)
    Observable<BaseEntity<PmovieBean>> getPmovie(@Query("city") String cityName,
                                                 @Query("key") String key);

}
