package com.open.verifymodule.verify.mpf;


import android.content.Context;
import android.os.Bundle;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-09.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public abstract class DefaultHandler implements Handler {
    protected Context mTarget;
    protected Bundle mArgument;
    private Handler mNext;

    public DefaultHandler(Context mTarget, Bundle mArgument) {
        this.mTarget = mTarget;
        this.mArgument = mArgument;
    }

    @Override
    public boolean handlerStatus(int status) {
        if (mNext != null) {
            mNext.handlerStatus(status);
            return true;
        }
        return false;
    }

    @Override
    public void setNext(Handler handler) {
        this.mNext = handler;
    }
}
