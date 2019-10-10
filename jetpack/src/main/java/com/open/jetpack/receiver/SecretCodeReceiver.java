package com.open.jetpack.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.open.interfaces.PluginFactory;
import com.open.interfaces.plugins.IAppPlugin;

import static android.provider.Telephony.Sms.Intents.SECRET_CODE_ACTION;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-10-10.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class SecretCodeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && SECRET_CODE_ACTION.equals(intent.getAction())) {
            IAppPlugin appPlugin = PluginFactory.getSingleton().getPlugin(IAppPlugin.class);
            if (appPlugin != null)
                appPlugin.startApp();
        }
    }
}