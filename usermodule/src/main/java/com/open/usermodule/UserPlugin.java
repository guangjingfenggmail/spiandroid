package com.open.usermodule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.open.PluginResult;
import com.open.event.LoginEvent;
import com.open.interfaces.PluginResultCallback;
import com.open.interfaces.plugins.IUserPlugin;
import com.open.jetpack.livedata.LiveDataBus;
import com.open.rxjava.RxBus;
import com.open.usermodule.event.LiveLoginEvent;
import com.open.usermodule.login.LoginActivity;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

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
//    Disposable disposable = null;

    @Override
    public String pluginName() {
        return "UserPlugin";
    }

    @Override
    public void toLogin(Context context, Bundle bundle, final PluginResultCallback callback) {
        if (context == null)
            return;

        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);


        LiveDataBus.get().of(LiveLoginEvent.class).login().observe(((ComponentActivity) context)
                , new Observer<Integer>() {
            @Override
            public void onChanged(Integer code) {
                if (code == 0) {
                    callback.onPluginResult(PluginResult.newBuilder().success(null).build());
                } else {
                    callback.onPluginResult(PluginResult.newBuilder().error("", -2).build());
                }
            }
        });

//        disposable = RxBus.getInstance().toObservable().map(new Function<Object, LoginEvent>() {
//            @Override
//            public LoginEvent apply(Object o) throws Exception {
//                return (LoginEvent) o;
//            }
//        }).subscribe(new Consumer<LoginEvent>() {
//            @Override
//            public void accept(LoginEvent loginEvent) throws Exception {
//                if (loginEvent != null) {
//                    if (loginEvent.code == 0) {
//                        callback.onPluginResult(PluginResult.newBuilder().success(null).build());
//                    } else {
//                        callback.onPluginResult(PluginResult.newBuilder().error("", -2).build());
//                    }
//                }
//                disposable.dispose();
//            }
//        });
    }
}
