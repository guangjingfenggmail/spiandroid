package com.open.borrowmodule;

import android.util.Log;

import com.google.auto.service.AutoService;
import com.open.interfaces.plugins.IBorrowPlugin;


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
@AutoService(IBorrowPlugin.class)
public class BorrowPlugin   implements IBorrowPlugin {

    @Override
    public String pluginName() {
        return "BorrowPlugin";
    }

    @Override
    public void toBorrow() {
        Log.e("BorrowPlugin", "toBorrow");
    }
}
