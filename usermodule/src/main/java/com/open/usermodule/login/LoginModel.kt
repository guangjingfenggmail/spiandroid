package com.open.usermodule.login

import java.io.Serializable

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-04.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 */
public open class LoginModel(var mobile: String, var password: String) : Serializable {
    var isEnable = false
}
