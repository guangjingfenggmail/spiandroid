package com.open.jetpack;

 import android.content.Context;

 import androidx.fragment.app.FragmentActivity;
 import androidx.lifecycle.ViewModel;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-06.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Presenter<T, V extends ViewModel> {

    protected FragmentActivity context;
    protected T model;
    protected V viewModel;


    public Presenter(FragmentActivity context, V viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    public Presenter(FragmentActivity context, T model, V viewModel) {
        this.context = context;
        this.model = model;
        this.viewModel = viewModel;
    }

    public Context getContext() {
        return context;
    }

    public T getModel() {
        return model;
    }

    public V getViewModel() {
        return viewModel;
    }
}
