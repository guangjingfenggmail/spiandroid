package com.open.spiapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.open.spiapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainModel model = new MainModel("userplugin", "borrowplugin");
        mainViewModel = new MainViewModel(model);
        mBinding.setModel(model);

        mBinding.setPresenter(new MainPresenter(mainViewModel, model));
    }


}
