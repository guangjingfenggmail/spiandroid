package com.open.jetpack;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.open.jetpack.provider.ApplicationContextProvider;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-10-09.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class ContextProvider {
    @SuppressLint("StaticFieldLeak")
    private static volatile ContextProvider instance;
    private Context mContext;

    private ContextProvider(Context context) {
        mContext = context;
    }

    /**
     * 获取实例
     */
    public static ContextProvider get() {
        if (instance == null) {
            synchronized (ContextProvider.class) {
                if (instance == null) {
                    Context context = ApplicationContextProvider.mContext;
                    if (context == null) {
                        throw new IllegalStateException("context == null");
                    }
                    instance = new ContextProvider(context);
                }
            }
        }
        return instance;
    }

    /**
     * 获取上下文
     */
    public Context getContext() {
        return mContext;
    }

    public Application getApplication() {
        return (Application) mContext.getApplicationContext();
    }
}