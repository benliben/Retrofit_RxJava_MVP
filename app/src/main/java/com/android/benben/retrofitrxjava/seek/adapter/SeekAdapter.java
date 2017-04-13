package com.android.benben.retrofitrxjava.seek.adapter;

import android.content.Context;
import android.speech.tts.Voice;
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

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Time      2017/4/10 16:34 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SeekAdapter extends RecyclerView.Adapter<SeekAdapter.MyViewHolder> {
    private Context mContext;
    private ABean mData;
    private LayoutInflater mInflater;
    private MyItemClickListener itemClickListener;

    public SeekAdapter(Context mContext, ABean mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_seek, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (mData != null) {
            holder.mSeekName.setText("片名:" + mData.getTitle() + "(" + mData.getYear() + ")");
            holder.mSeekType.setText("类型:" + mData.getTag());
            holder.mSeekAct.setText("演员:" + mData.getAct());
            holder.mSeekArea.setText("产地:" + mData.getArea() + "(" + mData.getRating() + ")");
            holder.mSeekDir.setText("导演:" + mData.getDir());
            Glide.with(mContext).load(mData.getCover()).into(holder.mSeekCover);
        }
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getAdapterPosition();
                    itemClickListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.item_seek_name)
        TextView mSeekName;
        @InjectView(R.id.item_seek_type)
        TextView mSeekType;
        @InjectView(R.id.item_seek_act)
        TextView mSeekAct;
        @InjectView(R.id.item_seek_area)
        TextView mSeekArea;
        @InjectView(R.id.item_seek_dir)
        TextView mSeekDir;
        @InjectView(R.id.item_seek_cover)
        ImageView mSeekCover;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }



    public void setMyItemClickListener(MyItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
