package com.android.benben.retrofitrxjava.utils;

import android.view.View;

/**
 * Time      2017/4/11 16:44 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface MyItemClickListener {
    void onItemClick(View mView, int position);

    void onItemLongClick(View mView, int position);
}
