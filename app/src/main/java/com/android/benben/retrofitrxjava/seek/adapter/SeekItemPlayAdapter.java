package com.android.benben.retrofitrxjava.seek.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.benben.retrofitrxjava.R;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.seek.view.SeekItemActivity;
import com.android.benben.retrofitrxjava.utils.MyItemClickListener;

/**
 * Time      2017/4/11 16:25 .
 * Author   : LiYuanXiong.
 * Content  :播放适配器
 */

public class SeekItemPlayAdapter extends RecyclerView.Adapter<SeekItemPlayAdapter.MyViewHolder> {
    private Context mContext;
    private ABean.PlaylinksBean mData;
    private LayoutInflater mInflater;

    public SeekItemPlayAdapter(Context mContext, ABean.PlaylinksBean mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_seek_play, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,  int position) {
        if (mData != null) {
//            switch (mData.get)
        }
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getAdapterPosition();
                    mItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getAdapterPosition();
                    mItemClickListener.onItemLongClick(holder.itemView,pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        public MyViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.item_seek_play_name);
        }
    }



    private MyItemClickListener mItemClickListener;

    private void setItemClick(MyItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
