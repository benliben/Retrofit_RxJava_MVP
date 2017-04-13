package com.android.benben.retrofitrxjava.site.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.android.benben.retrofitrxjava.R;
import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.bean.PmovieBean;
import com.android.benben.retrofitrxjava.seek.adapter.SeekAdapter;
import com.android.benben.retrofitrxjava.site.adapter.SiteAdapter;
import com.android.benben.retrofitrxjava.site.presenter.SitePresenter;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Time      2017/4/12 11:06 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class SiteActivity extends BaseActivity implements ISiteView {



    @InjectView(R.id.sit_et)
    EditText mEt;
    @InjectView(R.id.set_rv_up)
    RecyclerView mRvUp;
    @InjectView(R.id.set_rv_down)
    RecyclerView mRvDown;
    private SitePresenter mPresenter;
    private SiteAdapter mAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        ButterKnife.inject(this);
        mPresenter = new SitePresenter(this);
        initView();
    }

    private void initView() {
        mEt.setHint(R.string.app_name);
    }

    @Override
    public void quireSuccess(BaseEntity<PmovieBean> t) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        mRvUp.setLayoutManager(new LinearLayoutManager(this));
        mRvDown.setLayoutManager(new LinearLayoutManager(this));
        mRvUp.addItemDecoration(new mD(this,1,0xff666666));
        mAdapter = new SiteAdapter(this, t.getResult().getData().get(0).getData());
        mRvUp.setAdapter(mAdapter);
        mAdapter = new SiteAdapter(this, t.getResult().getData().get(1).getData());
        mRvDown.setAdapter(mAdapter);

    }

    public class mD extends Y_DividerItemDecoration{

        public mD(Context context, float lineWidthDp, @ColorInt int colorRGB) {
            super(context, lineWidthDp, colorRGB);
        }

        @Override
        public boolean[] getItemSidesIsHaveOffsets(int itemPosition) {
            //顺时针顺序:left, top, right, bottom
            boolean[] isOffset = {true, true, true, true};//默认只有bottom显示分割线

            return isOffset;
        }
    }

    @Override
    public void quireFail(Throwable e, boolean isNetWorkError) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.sit_button)
    public void onViewClicked() {
        if (!mEt.getText().toString().isEmpty()) {
            String name = mEt.getText().toString();
            mPresenter.inQuire(name,
                    this);
        } else {
            Toast.makeText(this,  "请输入要查询的城市", Toast.LENGTH_SHORT).show();
        }
    }


}
