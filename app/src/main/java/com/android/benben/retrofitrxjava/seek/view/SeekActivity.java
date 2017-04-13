package com.android.benben.retrofitrxjava.seek.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.speech.tts.Voice;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.benben.retrofitrxjava.R;
import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;

import com.android.benben.retrofitrxjava.seek.adapter.SeekAdapter;
import com.android.benben.retrofitrxjava.seek.presenter.SeekPresenter;
import com.android.benben.retrofitrxjava.utils.MyItemClickListener;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Time      2017/4/10 15:42 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SeekActivity extends BaseActivity implements ISeekView {
    @InjectView(R.id.seek_et)
    EditText mEt;
    @InjectView(R.id.seek_rv)
    RecyclerView mRv;

    private SeekPresenter mPresenter;
    private SeekAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.inject(this);
        mPresenter = new SeekPresenter(this);

    }

    @Override
    public void quireSuccess(final BaseEntity<ABean> t) {
        hindDialog();
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SeekAdapter(this,t.getResult());
        mRv.setAdapter(mAdapter);
        mAdapter.setMyItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View mView, int position) {
                Intent intent = new Intent(SeekActivity.this, SeekItemActivity.class);
                intent.putExtra("data",t.getResult());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View mView, int position) {

            }
        });
//        mAdapter.setMyItemClickListener(new SeekAdapter.MyItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//
//            @Override
//            public void onItemLongClick(Voice view, int position) {
//            }
//        });
    }

    @Override
    public void quireFail(Throwable e) {
        hindDialog();
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.seek_button)
    public void onViewClicked() {
        initET();
    }

    private void initET() {
        String mMoveName = mEt.getText().toString();
        if (mMoveName.isEmpty()) {
            Toast.makeText(this, "请输入要查询的电影名称", Toast.LENGTH_SHORT).show();
        } else {
            showDialog("加载中");
            mPresenter.inQuire(mMoveName,this);
        }
    }
}
