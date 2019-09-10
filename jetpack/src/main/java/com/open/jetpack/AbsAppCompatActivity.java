package com.open.jetpack;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

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
public abstract class AbsAppCompatActivity<T extends ViewDataBinding, PT extends Object, VM extends ViewModel, P extends Presenter<PT, VM>> extends AppCompatActivity {
    protected T mBinding;
    protected PT mModel;
    protected VM mViewModel;
    protected P mPresenter;

    /***
     * 设置布局
     * @return
     */
    protected abstract @LayoutRes
    int setLayout();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, setLayout());

        setBinding();
    }

    /**
     * viewmodel
     *
     * @param modelClas
     */
    protected void initProvider(@NonNull Class<VM> modelClas) {
        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(modelClas);
    }

    /**
     *
     */
    protected abstract void setBinding();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter = null;
        }
    }


}
