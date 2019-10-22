package com.open.jetpack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.open.jetpack.proxy.Proxy;
import com.open.jetpack.proxy.ProxyFragment;

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
public abstract class AbsFragment<T extends ViewDataBinding, PT extends Object, VM extends AndroidViewModel, P extends Presenter<PT, VM>> extends Fragment {
    protected T mBinding;
    protected PT mModel;
    protected VM mViewModel;
    protected P mPresenter;
    protected ProxyFragment mProxy;


    /***
     * 设置布局
     * @return
     */
    protected abstract @LayoutRes
    int setLayout();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mProxy = new ProxyFragment(getActivity(), setLayout(),inflater,container,savedInstanceState);
        mBinding = (T) mProxy.onCreate();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
    public void onDestroyView() {
        super.onDestroyView();
        mProxy.onDestroy();
    }
}


