package com.open;

import android.os.Bundle;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-06.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class PluginResult {
    //回调信息
    private int mResultCode;//0 成功，-1取消 -2 失败
    private Bundle mResult;
    private Object mExtra;

    //接口基本信息
    private int mErrorCode;
    private String mErrorMsg;

    public static PluginResultBuilder newBuilder() {
        return new PluginResultBuilder(null);
    }

    public PluginResultBuilder toBuilder() {
        return new PluginResultBuilder(this);
    }

    public boolean isSuccess() {
        return mResultCode == 0;
    }

    public boolean isFailed() {
        return mResultCode == -2;
    }

    public boolean isCancel() {
        return mResultCode == -1;
    }


    public int getResultCode() {
        return mResultCode;
    }

    public Bundle getResult() {
        return mResult;
    }

    public Object getExtra() {
        return mExtra;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public String getErrorMsg() {
        return mErrorMsg;
    }

    public static class PluginResultBuilder {
        //回调信息
        private int mResultCode;
        private Bundle mResult;
        private Object mExtra;

        //接口基本信息
        private int mErrorCode;
        private String mErrorMsg;

        public PluginResultBuilder(PluginResult result) {
            if (result != null) {
                this.mResultCode = result.mResultCode;
                this.mResult = result.mResult;
                this.mExtra = result.mExtra;

                this.mErrorCode = result.mErrorCode;
                this.mErrorMsg = result.mErrorMsg;
            }
        }

        public PluginResultBuilder success(Bundle result) {
            mResult = result;
            mResultCode = 0;
            return PluginResultBuilder.this;
        }

        public PluginResultBuilder error(String errorMsg, int errorCode) {
            mErrorMsg = errorMsg;
            mErrorCode = errorCode;
            mResultCode = -2;
            return PluginResultBuilder.this;
        }

        public PluginResultBuilder cancel() {
            mResultCode = -1;
            return PluginResultBuilder.this;
        }

        public PluginResultBuilder extras(Object extras) {
            mExtra = extras;
            return PluginResultBuilder.this;
        }

        public PluginResult build() {
            PluginResult result = new PluginResult();
            result.mErrorCode = mErrorCode;
            result.mErrorMsg = mErrorMsg;
            result.mResultCode = mResultCode;
            result.mResult = mResult;
            result.mExtra = mExtra;
            return result;
        }

    }
}
