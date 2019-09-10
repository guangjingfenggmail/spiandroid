package com.open.jetpack.proxy;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

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
public interface IProxy {

    ViewDataBinding onCreate();

    <V extends ViewModel> V initProvider(@NonNull Class<V> modelClass);

    void onDestroy();


}
