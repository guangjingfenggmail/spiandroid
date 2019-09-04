package com.open.usermodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.open.usermodule.login.LoginActivity;

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
    public String pluginName() {
        return "UserPlugin";
    }

    @Override
    public void toLogin(Context context, Bundle bundle) {
        Log.e("UserPlugin", "todo login");
        if (context == null)
            return;

        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
