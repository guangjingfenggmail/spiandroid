package com.open.usermodule;


import android.content.Context;
import android.os.Bundle;

import com.open.interfaces.Plugin;

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
public interface IUserPlugin extends Plugin {

    void toLogin(Context context, Bundle bundle);

}
