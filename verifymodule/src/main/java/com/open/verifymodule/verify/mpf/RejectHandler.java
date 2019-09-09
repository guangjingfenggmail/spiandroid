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
public class RejectHandler extends DefaultHandler {

    public RejectHandler(Context mTarget, Bundle mArgument) {
        super(mTarget, mArgument);
    }

    @Override
    public boolean handlerStatus(int status) {
        if (status == 5004) {
            return true;
        }
        return super.handlerStatus(status);
    }
}
