package com.open.verifymodule.mpf;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.open.jetpack.AbsAppCompatActivity;
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
public class MpfActivity extends AbsAppCompatActivity<ActivityMpfBinding, MpfModel, MpfViewModel, MpfPresenter> {

    @Override
    protected int setLayout() {
        return R.layout.activity_mpf;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProvider(MpfViewModel.class);
    }


    @Override
    protected void setBinding() {
        MpfModel model = new MpfModel();
        mBinding.setModel(model);

        mPresenter = new MpfPresenter(this, model, mViewModel);
        mBinding.setPresenter(mPresenter);
    }
}
