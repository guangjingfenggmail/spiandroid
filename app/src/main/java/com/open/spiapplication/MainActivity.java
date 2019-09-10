package com.open.spiapplication;

import android.os.Bundle;
import android.util.Log;

import com.open.aspectjx.DebugLog;
import com.open.jetpack.AbsAppCompatActivity;
import com.open.spiapplication.databinding.ActivityMainBinding;

public class MainActivity extends AbsAppCompatActivity<ActivityMainBinding, MainModel, MainViewModel, MainPresenter> {
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @DebugLog(level = Log.DEBUG, tag = "MainActivity", msg = "onCreate")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProvider(MainViewModel.class);
    }


    @Override
    protected void setBinding() {
        mModel = new MainModel("userplugin", "borrowplugin", "verifymodule");
        mBinding.setModel(mModel);

        mPresenter = new MainPresenter(this, mModel, mViewModel);
        mBinding.setPresenter(mPresenter);
    }


    @DebugLog(level = Log.DEBUG, tag = "MainActivity", msg = "onResume")
    @Override
    protected void onResume() {
        super.onResume();
    }

    @DebugLog(level = Log.DEBUG, tag = "MainActivity", msg = "onDestroy")
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
