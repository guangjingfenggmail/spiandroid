package com.open.interfaces;


import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceLoader;

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
public final class PluginFactory {
    private static HashMap mMap = new HashMap();

    public static <T> T getPlugin(Class<T> mclass) {
        T plugin = null;
        if (mMap.containsKey(mclass.getSimpleName())) {
            plugin = (T) mMap.get(mclass.getSimpleName());
            return plugin;
        }

        /**
         * @AutoService(IAppPlugin.class)
         * public class AppPlugin implements IAppPlugin {}
         *
         * 主app模块
         *
         *  UserPlugin plugin = PluginFactory.getPlugin(UserPlugin.class);
         *
         *  Log.e("MainActivity", "plugin===" + plugin.pluginName());
         */
        Class<? super T> rawType = (Class<? super T>) mclass.getGenericInterfaces()[0];
        if (rawType == null)
            return plugin;


        /***
         *  子module相互调用
         *
         *  IUserPlugin plugin = PluginFactory.getPlugin(IUserPlugin.class);
         *
         *  Log.e("MpfPresenter", "IUserPlugin==" + plugin.pluginName());
         */
        if (rawType == Plugin.class) {
            rawType = mclass;
        }

        ServiceLoader<T> loader = (ServiceLoader<T>) ServiceLoader.load(rawType);

        Iterator<T> iterator = loader.iterator();
        while (iterator.hasNext()) {
            mMap.put(mclass.getSimpleName(), iterator.next());
        }

        if (mMap.containsKey(mclass.getSimpleName())) {
            plugin = (T) mMap.get(mclass.getSimpleName());
            return plugin;
        }

        return plugin;
    }


}
