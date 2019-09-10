package com.open.spiapplication.plugin;

import com.google.auto.service.AutoService;
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
@AutoService(IAppPlugin.class)
public class AppPlugin   implements IAppPlugin {
    @Override
    public String pluginName() {
        return "AppPlugin";
    }
}
