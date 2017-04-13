package com.android.benben.retrofitrxjava.seek.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.benben.retrofitrxjava.R;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.utils.MyItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Time      2017/4/11 16:25 .
 * Author   : LiYuanXiong.
 * Content  :演员适配器
 */

public class SeekItemActAdapter extends RecyclerView.Adapter<SeekItemActAdapter.MyViewHolder> {
    private Context mContext;
    private List<ABean.ActSBean> mData;
    private LayoutInflater mInflater;

    public SeekItemActAdapter(Context mContext, List<ABean.ActSBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_seek_act, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (mData != null) {
            holder.mName.setText(mData.get(position).getName());
            Glide.with(mContext).load(mData.get(position).getImage()).into(holder.mImage);
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
                    mItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.item_seek_act_name);
            mImage = (ImageView) itemView.findViewById(R.id.item_seek_act_image);
        }
    }


    private MyItemClickListener mItemClickListener;

    public void setItemClick(MyItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
