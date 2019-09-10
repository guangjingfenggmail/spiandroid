package com.open.jetpack.proxy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class ProxyFragment<P extends Presenter> extends Proxy<P> {
    LayoutInflater inflater;
    @Nullable
    ViewGroup container;
    @Nullable
    Bundle savedInstanceState;

    public ProxyFragment(FragmentActivity activity, int layoutId, @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super(activity, layoutId);
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
    }

    @Override
    public ViewDataBinding onCreate() {
        return DataBindingUtil.inflate(inflater, mLayoutId, container, false);

    }
}
