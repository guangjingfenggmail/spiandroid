package com.open.jetpack;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.open.jetpack.proxy.Proxy;
import com.open.jetpack.proxy.ProxyActivity;

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
public abstract class AbsAppCompatActivity<T extends ViewDataBinding, PT extends Object, VM extends AndroidViewModel, P extends Presenter<PT, VM>> extends AppCompatActivity {
    protected T mBinding;
    protected PT mModel;
    protected VM mViewModel;
    protected P mPresenter;
    protected ProxyActivity mProxy;

    /***
     * 设置布局
     * @return
     */
    protected abstract @LayoutRes
    int setLayout();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProxy = new ProxyActivity<P>(this, setLayout());
        mBinding = (T) mProxy.onCreate();
    }

    /**
     * viewmodel
     *
     * @param modelClas
     */
    protected void initProvider(@NonNull Class<VM> modelClas) {
        mViewModel = (VM) mProxy.initProvider(modelClas);
        setBinding();
    }

    /**
     *
     */
    protected abstract void setBinding();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxy.onDestroy();
    }


}
