package com.open.verifymodule;

import android.content.Context;
import android.os.Bundle;

import com.open.interfaces.Plugin;
import com.open.interfaces.PluginResultCallback;

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
public interface IVerifyPlugin extends Plugin {

    void toVerify(Context context, Bundle bundle, PluginResultCallback callback);

    /**
     * @param context
     * @param bundle
     * @param callback
     */
    void verify(Context context, Bundle bundle, PluginResultCallback callback);

    /**
     * @param context
     * @param bundle
     * @param callback
     */
    void facial(Context context, Bundle bundle, PluginResultCallback callback);

    /**
     * @param context
     * @param bundle
     * @param callback
     */
    void trigger(Context context, Bundle bundle, PluginResultCallback callback);

    /**
     * @param context
     * @param bundle
     * @param callback
     */
    void agreement(Context context, Bundle bundle, PluginResultCallback callback);

}
