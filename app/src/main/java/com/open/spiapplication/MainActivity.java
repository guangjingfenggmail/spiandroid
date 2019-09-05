package com.open.spiapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.open.aspectjx.DebugLog;
import com.open.spiapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MainViewModel mainViewModel;
    private MainPresenter mPresenter;

    @DebugLog(level = Log.DEBUG,tag = "MainActivity",msg = "onCreate")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainModel model = new MainModel("userplugin", "borrowplugin");
        mainViewModel = new MainViewModel(model);
        mBinding.setModel(model);

        mPresenter = new MainPresenter(mainViewModel, model);
        mBinding.setPresenter(mPresenter);

    }

    @DebugLog(level = Log.DEBUG,tag = "MainActivity",msg = "onResume")
    @Override
    protected void onResume() {
        super.onResume();
    }

    @DebugLog(level = Log.DEBUG,tag = "MainActivity",msg = "onDestroy")
    @Override
    protected void onDestroy() {
        super.onDestroy();
     }
}
