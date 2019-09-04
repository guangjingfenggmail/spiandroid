package com.open.spiapplication;

import androidx.databinding.ObservableField;

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
public class MainModel {

    public ObservableField<String> user = new ObservableField<>();
    public ObservableField<String> borrow = new ObservableField<>();

    public MainModel(String user, String borrow) {
        this.user.set(user);
        this.borrow.set(borrow);
    }


}
