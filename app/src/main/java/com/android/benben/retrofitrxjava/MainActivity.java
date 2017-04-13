package com.android.benben.retrofitrxjava;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.benben.retrofitrxjava.common.BaseActivity;
import com.android.benben.retrofitrxjava.http.RetrofitFactory;
import com.android.benben.retrofitrxjava.http.base.BaseObserver;
import com.android.benben.retrofitrxjava.http.bean.ABean;
import com.android.benben.retrofitrxjava.http.bean.BaseEntity;
import com.android.benben.retrofitrxjava.http.config.HttpConfig;
import com.android.benben.retrofitrxjava.seek.view.SeekActivity;
import com.android.benben.retrofitrxjava.site.view.SiteActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
//        getData();
    }

    public void getData() {
        RetrofitFactory.getInstence().API()
                .getVideo("功夫", HttpConfig.KEY)
                .compose(this.<BaseEntity<ABean>>setThread())
                .subscribe(new BaseObserver<ABean>() {
                    @Override
                    protected void onSuccess(BaseEntity<ABean> t) throws Exception {
                        Toast.makeText(MainActivity.this, "c成功" + t.getResult().getDir(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        Log.i("lyx", "onFailure: " + e.getMessage());
                        Toast.makeText(MainActivity.this, "失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void onCodeError(BaseEntity<ABean> t) throws Exception {
                        super.onCodeError(t);
                        Toast.makeText(MainActivity.this, t.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @OnClick({R.id.main_button1, R.id.main_button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_button1:
                startActivity(new Intent(MainActivity.this, SeekActivity.class));
                break;
            case R.id.main_button2:
                startActivity(new Intent(MainActivity.this, SiteActivity.class));
                break;
        }
    }
}
