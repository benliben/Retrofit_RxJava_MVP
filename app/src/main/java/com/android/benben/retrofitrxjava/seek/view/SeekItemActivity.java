package com.android.benben.retrofitrxjava.seek.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.benben.retrofitrxjava.R;
import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.seek.adapter.SeekItemActAdapter;
import com.android.benben.retrofitrxjava.seek.adapter.SeekItemPlayAdapter;
import com.android.benben.retrofitrxjava.seek.adapter.SeekItemVideoAdapter;
import com.android.benben.retrofitrxjava.utils.MyItemClickListener;
import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Time      2017/4/11 14:25 .
 * Author   : LiYuanXiong.
 * Content  :
 */
public class SeekItemActivity extends BaseActivity {
    @InjectView(R.id.seek_item_image)
    ImageView mItemImage;
    @InjectView(R.id.seek_item_toolbar)
    Toolbar mItemToolbar;
    @InjectView(R.id.seek_item_coll_toolbar)
    CollapsingToolbarLayout mItemCollToolbar;
    @InjectView(R.id.seek_item_appbar)
    AppBarLayout mItemAppbar;
    @InjectView(R.id.seek_item_title)
    TextView mItemTitle;
    @InjectView(R.id.seek_item_tag)
    TextView mItemTag;
    @InjectView(R.id.seek_item_act)
    TextView mItemAct;
    @InjectView(R.id.seek_item_year)
    TextView mItemYear;
    @InjectView(R.id.seek_item_rating)
    TextView mItemRating;
    @InjectView(R.id.seek_item_area)
    TextView mItemArea;
    @InjectView(R.id.seek_item_dir)
    TextView mItemDir;
    @InjectView(R.id.seek_item_desc)
    TextView mItemDesc;
    @InjectView(R.id.seek_item_video_rec)
    RecyclerView mItemVideoRec;
    @InjectView(R.id.seek_item_act_s)
    RecyclerView mItemActS;
    @InjectView(R.id.seek_item_levp)
    TextView mItemLevp;
    @InjectView(R.id.seek_item_huashu)
    TextView mItemHuashu;
    @InjectView(R.id.seek_item_fengxing)
    TextView mItemFengxing;
    @InjectView(R.id.seek_item_qq)
    TextView mItemQq;
    @InjectView(R.id.seek_item_sohu)
    TextView mItemSohu;
    @InjectView(R.id.seek_item_youku)
    TextView mItemYouku;
    private ABean mData;
    private SeekItemPlayAdapter mPlayAdapter;//播放
    private SeekItemVideoAdapter mVideoAdapter;//电影
    private SeekItemActAdapter mActAdapter;//演员

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_item);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        mData = (ABean) getIntent().getSerializableExtra("data");
        bingDingData();
    }

    private void bingDingData() {
        mItemCollToolbar.setTitle(mData.getTitle());
        mItemCollToolbar.setExpandedTitleColor(Color.WHITE);
        mItemCollToolbar.setCollapsedTitleTextColor(Color.WHITE);
        mItemTitle.setText("片名:" + mData.getTitle());
        mItemTag.setText("类型:" + mData.getTag());
        mItemAct.setText("演员:" + mData.getAct());
        mItemYear.setText("时间:" + mData.getYear());
        mItemRating.setText("评分:" + mData.getRating());
        mItemArea.setText("产地:" + mData.getArea());
        mItemDir.setText("导演:" + mData.getDir());
        mItemDesc.setText("简介:" + mData.getDesc());
        Glide.with(this).load(mData.getCover()).into(mItemImage);

        mItemLevp.setText("乐视:" + (mData.getPlaylinks().getLevp() == null ? "无链接" : "点击查看视屏"));
        mItemHuashu.setText("华数:" + (mData.getPlaylinks().getHuashu() == null ? "无链接" : "点击查看视屏"));
        mItemFengxing.setText("风行:" + (mData.getPlaylinks().getFengxing() == null ? "无链接" : "点击查看视屏"));
        mItemQq.setText("腾讯:" + (mData.getPlaylinks().getQq() == null ? "无链接" : "点击查看视屏"));
        mItemSohu.setText("搜狐:" + (mData.getPlaylinks().getSohu() == null ? "无链接" : "点击查看视屏"));
        mItemYouku.setText("优酷:" + (mData.getPlaylinks().getYouku() == null ? "无链接" : "点击查看视屏"));


        mItemVideoRec.setLayoutManager(new LinearLayoutManager(this));
        mVideoAdapter = new SeekItemVideoAdapter(this, mData.getVideo_rec());
        mItemVideoRec.setAdapter(mVideoAdapter);

        mVideoAdapter.setItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View mView, int position) {
                Toast.makeText(SeekItemActivity.this, "" + mData.getVideo_rec().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View mView, int position) {

            }
        });

        mItemActS.setLayoutManager(new GridLayoutManager(this, 2));
        mActAdapter = new SeekItemActAdapter(this, mData.getAct_s());
        mItemActS.setAdapter(mActAdapter);
        mActAdapter.setItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View mView, int position) {
                Toast.makeText(SeekItemActivity.this, "" + mData.getAct_s().get(position).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View mView, int position) {

            }
        });
    }

    @OnClick({R.id.seek_item_levp, R.id.seek_item_huashu, R.id.seek_item_fengxing, R.id.seek_item_qq, R.id.seek_item_sohu, R.id.seek_item_youku})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.seek_item_levp:
                break;
            case R.id.seek_item_huashu:
                break;
            case R.id.seek_item_fengxing:
                break;
            case R.id.seek_item_qq:
                break;
            case R.id.seek_item_sohu:
                break;
            case R.id.seek_item_youku:
                break;
        }
    }
}
