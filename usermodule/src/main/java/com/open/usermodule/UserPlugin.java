package com.open.usermodule;

import android.util.Log;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-03.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class UserPlugin implements IUserPlugin {

    @Override
    public void toLogin() {
        Log.e("UserPlugin", "todo login");
    }

    @Override
    public String pluginName() {
        return "UserPlugin";
    }
}
