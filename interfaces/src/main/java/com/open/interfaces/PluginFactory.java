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

        Class<? super T> rawType = (Class<? super T>) mclass.getGenericInterfaces()[0];
        if (rawType == null)
            return plugin;

        if (rawType == Plugin.class){
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
