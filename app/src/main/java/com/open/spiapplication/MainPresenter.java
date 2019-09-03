package com.open.spiapplication;

import android.util.Log;
import android.view.View;

import com.open.borrowmodule.BorrowPlugin;
import com.open.usermodule.UserPlugin;

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
public class MainPresenter {

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUser:
                UserPlugin plugin = PluginFactory.getSingleton().getPlugin(UserPlugin.class);
                Log.e("MainActivity", "plugin===" + plugin.pluginName());
                plugin.toLogin();
                break;
            case R.id.btnBorrow:
                BorrowPlugin plugin2 = PluginFactory.getSingleton().getPlugin(BorrowPlugin.class);
                Log.e("MainActivity", "plugin2===" + plugin2.pluginName());
                plugin2.toBorrow();
                break;
        }
    }


}
