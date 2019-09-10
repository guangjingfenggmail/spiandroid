package com.open.verifymodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.auto.service.AutoService;
import com.open.interfaces.PluginResultCallback;
import com.open.interfaces.plugins.IVerifyPlugin;
import com.open.verifymodule.mpf.MpfActivity;

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
@AutoService(IVerifyPlugin.class)
public class VerifyPlugin  implements IVerifyPlugin {
    @Override
    public void toVerify(Context context, Bundle bundle, PluginResultCallback callback) {

        if (context == null)
            return;

        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(context, MpfActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void verify(Context context, Bundle bundle, PluginResultCallback callback) {

    }

    @Override
    public void facial(Context context, Bundle bundle, PluginResultCallback callback) {

    }

    @Override
    public void trigger(Context context, Bundle bundle, PluginResultCallback callback) {

    }

    @Override
    public void agreement(Context context, Bundle bundle, PluginResultCallback callback) {

    }

    @Override
    public String pluginName() {
        return "VerifyPlugin";
    }
}
