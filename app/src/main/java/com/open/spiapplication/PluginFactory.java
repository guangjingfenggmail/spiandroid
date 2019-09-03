package com.open.spiapplication;

import com.open.interfaces.Plugin;

import java.util.ArrayList;
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
public class PluginFactory {

    private static PluginFactory mPluginFactory;

    private ArrayList<Plugin> mList;

    private PluginFactory() {
        ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class);
        Iterator<Plugin> iterator = loader.iterator();
        mList = new ArrayList<>();
        while (iterator.hasNext()) {
            mList.add(iterator.next());
        }

    }

    static PluginFactory getSingleton() {
        if (null == mPluginFactory) {
            synchronized (PluginFactory.class) {
                if (null == mPluginFactory) {
                    mPluginFactory = new PluginFactory();
                }
            }
        }
        return mPluginFactory;
    }

    <T> T getPlugin(Class<T> mclass) {
        T plugin = null;
        for (Plugin p : mList) {
            if (p.getClass() == mclass) {
                plugin = (T) p;
                break;
            }
        }

        return plugin;
    }


}
