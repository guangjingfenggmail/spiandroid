package com.open.verifymodule.verify.mpf;

import android.content.Context;
import android.os.Bundle;

import com.open.PluginResult;
import com.open.interfaces.PluginResultCallback;
import com.open.verifymodule.VerifyPlugin;

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
public class TriggerHandler extends DefaultHandler {

    public TriggerHandler(Context mTarget, Bundle mArgument) {
        super(mTarget, mArgument);
    }

    @Override
    public boolean handlerStatus(int status) {
        if (status == 5002) {
            VerifyPlugin verifyPlugin = new VerifyPlugin();
            verifyPlugin.trigger(mTarget, mArgument, new PluginResultCallback() {
                @Override
                public void onPluginResult(PluginResult result) {
                    if (result.isSuccess()) {
                        TriggerHandler.super.handlerStatus(5006);
                    }
                }
            });

            return true;

        }
        return super.handlerStatus(status);
    }
}
