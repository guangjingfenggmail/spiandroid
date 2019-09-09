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
public class FacialHandler extends DefaultHandler {

    public FacialHandler(Context mTarget, Bundle mArgument) {
        super(mTarget, mArgument);
    }

    @Override
    public boolean handlerStatus(final int status) {
        if (status == 5001 || status == 5003) {
            VerifyPlugin verifyPlugin = new VerifyPlugin();
            verifyPlugin.facial(mTarget, mArgument, new PluginResultCallback() {
                @Override
                public void onPluginResult(PluginResult result) {
                    if (result.isSuccess()) {
                        FacialHandler.super.handlerStatus(5002);
                    }
                }
            });
            return true;
        }
        return super.handlerStatus(status);
    }
}
