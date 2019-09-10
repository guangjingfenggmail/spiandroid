package com.open.jetpack.proxy;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;

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
public class ProxyActivity<P extends Presenter> extends Proxy<P> {

    public ProxyActivity(FragmentActivity activity, int layoutId) {
        super(activity, layoutId);
    }

    @Override
    public ViewDataBinding onCreate() {
        return DataBindingUtil.setContentView(mActivity, mLayoutId);
    }
}
