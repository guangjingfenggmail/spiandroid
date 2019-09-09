package com.open.verifymodule.verify.mpf;

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
public interface Handler {
    /**
     * status mpf 用户模型相关
     * *      * <p>
     * *      * 5000：需要补资料升级模型，不需要人脸识别.
     * *      * 5001：需要补资料升级模型，且需要人脸识别.
     * *      * 5002：需要trigger preapprove.
     * *      * 5003：suspicious， 需要再次人脸识别.
     * *      * 5004: rejected.
     * *      * 5005：rejected 过期.
     * *      * 5006：需要开通协议
     *
     * @param status
     * @return
     */
    boolean handlerStatus(int status);


    void setNext(Handler handler);
}
