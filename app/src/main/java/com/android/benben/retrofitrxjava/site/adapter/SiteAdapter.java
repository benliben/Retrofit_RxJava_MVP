package com.android.benben.retrofitrxjava.site.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.benben.retrofitrxjava.R;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;
import com.bumptech.glide.Glide;

import java.security.PrivateKey;
import java.util.List;

/**
 * Time      2017/4/12 14:52 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.MyViewHolder> {
    private Context mContext;
    private List<PmovieBean.DataBeanXXXXXX.DataBeanXXXXX> mData;
    private LayoutInflater mInflater;

    public SiteAdapter(Context mContext, List<PmovieBean.DataBeanXXXXXX.DataBeanXXXXX> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_site, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (mData != null) {
            PmovieBean.DataBeanXXXXXX.DataBeanXXXXX item = mData.get(position);
            Glide.with(mContext).load(item.getIconaddress()).into(holder.mImage);
            holder.mTitle.setText("片名:"+item.getTvTitle());
            holder.mDirector.setText("导演:"+item.getDirector().getData().get_$1().getName());

            PmovieBean.DataBeanXXXXXX.DataBeanXXXXX.StarBean.DataBeanX name = item.getStar().getData();
            holder.mStar.setText("主演:"+name.get_$1().getName()+","+name.get_$2().getName()+","+name.get_$3().getName()+","+name.get_$4().getName());
            holder.mDate.setText("上映日期:"+item.getPlayDate().getData2());
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mTitle ,mDirector,mStar, mDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.item_site_image);
            mTitle = (TextView) itemView.findViewById(R.id.item_site_title);
            mDirector = (TextView) itemView.findViewById(R.id.item_site_director);
            mStar = (TextView) itemView.findViewById(R.id.item_site_star);
            mDate = (TextView) itemView.findViewById(R.id.item_site_date);
        }
    }
}
