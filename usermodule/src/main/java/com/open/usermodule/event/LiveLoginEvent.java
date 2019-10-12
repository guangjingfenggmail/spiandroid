package com.open.usermodule.event;


import com.open.jetpack.livedata.LiveDataBus;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-10-12.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public interface LiveLoginEvent {

    LiveDataBus.ExternalLiveData<Integer> login();
}
