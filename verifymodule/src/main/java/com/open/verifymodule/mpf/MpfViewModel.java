package com.open.verifymodule.mpf;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
public class MpfViewModel extends AndroidViewModel {
    public MutableLiveData<MpfModel> mMpfLiveData = new MutableLiveData<>();

    public MpfViewModel(@NonNull Application application) {
        super(application);
    }
}
