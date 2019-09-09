package com.open.verifymodule.mpf;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.open.verifymodule.R;
import com.open.verifymodule.databinding.ActivityMpfBinding;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-09.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class MpfActivity extends AppCompatActivity {
    private ActivityMpfBinding mBinding;
    private MpfViewModel mViewModel;
    private MpfPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mpf);


        MpfModel model = new MpfModel();
        mBinding.setModel(model);

        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MpfViewModel.class);

        mPresenter = new MpfPresenter(this, model, mViewModel);
        mBinding.setPresenter(mPresenter);
    }
}
