package com.open.spiapplication;

import android.app.Application;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-05.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class SpiApplication extends Application {
    private static SpiApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static SpiApplication getInstance() {
        return instance;
    }
}
