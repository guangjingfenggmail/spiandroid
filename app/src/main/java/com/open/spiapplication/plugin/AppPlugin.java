package com.open.spiapplication.plugin;

import android.content.ContentProvider;
import android.content.Intent;

import com.open.interfaces.plugins.IAppPlugin;
import com.open.jetpack.ContextProvider;
import com.open.spiapplication.MainActivity;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-10.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class AppPlugin implements IAppPlugin {
    @Override
    public String pluginName() {
        return "AppPlugin";
    }

    @Override
    public void startApp() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setClass(ContextProvider.get().getContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ContextProvider.get().getContext().startActivity(i);
    }
}
