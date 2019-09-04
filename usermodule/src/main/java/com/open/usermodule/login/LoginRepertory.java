package com.open.usermodule.login;

import com.open.retrofit.RetrofitRepertory;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-04.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class LoginRepertory extends RetrofitRepertory {

    private interface Service {
        @GET("/api/4/version/android/2.3.0")
        Observable<Account> signUp(
                @Query("mobile") String mobile,
                @Query("password") String password
        );
    }

    public Observable<Account> signUp(String mobile, String password) {
        return getRetrofit().create(Service.class).signUp(mobile, password);
    }


}
