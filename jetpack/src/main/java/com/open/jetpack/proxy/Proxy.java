package com.open.jetpack.proxy;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.open.jetpack.Presenter;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-10.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Proxy<P extends Presenter> implements IProxy {
    protected P mPresenter;
    protected @LayoutRes
    int mLayoutId;
    protected FragmentActivity mActivity;

    public Proxy(FragmentActivity activity, @LayoutRes int layoutId) {
        this.mActivity = activity;
        this.mLayoutId = layoutId;
    }

    @Override
    public ViewDataBinding onCreate() {
        return DataBindingUtil.setContentView(mActivity, mLayoutId);
    }

    @Override
    public <VM extends ViewModel> VM initProvider(@NonNull Class<VM> modelClass) {
        return new ViewModelProvider(mActivity, ViewModelProvider.AndroidViewModelFactory.getInstance(mActivity.getApplication())).get(modelClass);
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter = null;
        }
    }
}
