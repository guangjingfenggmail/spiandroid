package com.open.borrowmodule;

import android.util.Log;


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
public class BorrowPlugin implements IBorrowPlugin {

    @Override
    public String pluginName() {
        return "BorrowPlugin";
    }

    @Override
    public void toBorrow() {
        Log.e("BorrowPlugin", "toBorrow");
    }
}
