package com.open.spiapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.open.PluginResult;
import com.open.aspectjx.BizAInterceptor;
import com.open.aspectjx.DebugLog;
import com.open.aspectjx.DoubleClick;
import com.open.aspectjx.LoginInterceptor;
import com.open.aspectjx.Permission;
import com.open.borrowmodule.BorrowPlugin;
import com.open.interfaces.PluginFactory;
import com.open.interfaces.PluginResultCallback;
import com.open.jetpack.Presenter;
import com.open.usermodule.UserPlugin;
import com.open.verifymodule.VerifyPlugin;

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
public class MainPresenter extends Presenter<MainModel, MainViewModel> {

    public MainPresenter(FragmentActivity context, MainModel model, MainViewModel viewModel) {
        super(context, model, viewModel);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUser:
                toLogin(v.getContext());
                break;
            case R.id.btnBorrow:
                toBorrow();
                break;
            case R.id.btnVerify:
                toVerify(v.getContext());
                break;
        }
    }

    @DoubleClick(value = 1000)
    @LoginInterceptor(isLogin = true)
    @BizAInterceptor(event = 0)
    @DebugLog(level = Log.ERROR, tag = "MainPresenter", msg = "toLogin")
    private void toLogin(Context context) {
        UserPlugin plugin = PluginFactory.getPlugin(UserPlugin.class);
        Log.e("MainActivity", "plugin===" + plugin.pluginName());
        model.user.set(plugin.pluginName() + "onClick");
        plugin.toLogin(context, null, new PluginResultCallback() {
            @Override
            public void onPluginResult(PluginResult result) {

            }
        });
    }

    @DoubleClick(value = 1000)
    @Permission(request = {"android.permission.READ_PHONE_STATE"})
    @DebugLog(level = Log.ERROR, tag = "MainPresenter", msg = "toBorrow")
    private void toBorrow() {
        BorrowPlugin plugin2 = PluginFactory.getPlugin(BorrowPlugin.class);
        Log.e("MainActivity", "plugin2===" + plugin2.pluginName());
        model.borrow.set(plugin2.pluginName() + "onClick");
        plugin2.toBorrow();
    }

    @DoubleClick(value = 1000)
    @DebugLog(level = Log.ERROR, tag = "MainPresenter", msg = "toVerify")
    private void toVerify(Context context) {
        VerifyPlugin plugin = PluginFactory.getPlugin(VerifyPlugin.class);
        Log.e("MainActivity", "plugin===" + plugin.pluginName());
        model.verify.set(plugin.pluginName() + "onClick");
        plugin.toVerify(context, new Bundle(), new PluginResultCallback() {
            @Override
            public void onPluginResult(PluginResult result) {

            }
        });
    }


}
