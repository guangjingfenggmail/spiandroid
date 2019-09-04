package com.open.usermodule.login;

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
public class LoginViewModel extends ViewModel {
    public MutableLiveData<LoginModel> mloginLiveData = new MutableLiveData<>();
    public LoginRepertory mLoginRepertory = new LoginRepertory();

    public LoginViewModel() {

    }

}
