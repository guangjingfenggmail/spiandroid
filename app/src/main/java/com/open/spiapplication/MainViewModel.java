package com.open.spiapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-04.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class MainViewModel extends AndroidViewModel {
    public MutableLiveData<MainModel> mMainLiveData = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
