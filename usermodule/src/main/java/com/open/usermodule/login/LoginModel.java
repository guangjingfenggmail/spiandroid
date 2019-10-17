package com.open.usermodule.login;

import java.io.Serializable;

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
public class LoginModel implements Serializable {
    public String mobile;
    public String password;
    public boolean isEnable = false;

    public LoginModel(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }
}
