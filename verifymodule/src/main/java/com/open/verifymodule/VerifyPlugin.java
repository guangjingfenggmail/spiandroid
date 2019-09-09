package com.open.verifymodule;

import android.content.Context;
import android.os.Bundle;

import com.open.interfaces.PluginResultCallback;
import com.open.verifymodule.verify.mpf.AgreementHandler;
import com.open.verifymodule.verify.mpf.FacialHandler;
import com.open.verifymodule.verify.mpf.RejectHandler;
import com.open.verifymodule.verify.mpf.TriggerHandler;
import com.open.verifymodule.verify.mpf.VerifyInfoHandler;

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
public class VerifyPlugin implements IVerifyPlugin {
    @Override
    public void toVerify(Context context, Bundle bundle, PluginResultCallback callback) {
        VerifyInfoHandler verifyInfoHandler = new VerifyInfoHandler(context, bundle);
        FacialHandler facialHandler = new FacialHandler(context, bundle);
        TriggerHandler triggerHandler = new TriggerHandler(context, bundle);
        RejectHandler rejectHandler = new RejectHandler(context, bundle);
        AgreementHandler agreementHandler = new AgreementHandler(context, bundle);

        verifyInfoHandler.setNext(facialHandler);
        facialHandler.setNext(triggerHandler);
        triggerHandler.setNext(rejectHandler);
        rejectHandler.setNext(agreementHandler);
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
