package com.open.spiapplication.plugin;

import com.open.interfaces.plugins.IAppPlugin;

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
}
