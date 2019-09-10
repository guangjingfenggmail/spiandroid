package com.open.verifymodule.mpf;

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
public class MpfViewModel extends ViewModel {
    public MutableLiveData<MpfModel> mMpfLiveData = new MutableLiveData<>();

    public MpfViewModel() {
    }
}
