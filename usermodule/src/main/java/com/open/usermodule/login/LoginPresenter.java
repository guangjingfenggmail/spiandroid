package com.open.usermodule.login;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.open.aspectjx.DoubleClick;
import com.open.event.LoginEvent;
import com.open.rxjava.RxBus;
import com.open.usermodule.R;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
public class LoginPresenter {
    private LoginViewModel mViewModel;
    private Activity mActivity;

    public LoginPresenter(LoginViewModel mViewModel, Activity mActivity) {
        this.mViewModel = mViewModel;
        this.mActivity = mActivity;
    }

    @DoubleClick(value = 1000)
    public void onClick(View v, LoginModel mMode) {
        if (v.getId() == R.id.btnSubmit) {
            if (validate(mMode)) {
                mViewModel.mLoginRepertory.signUp(mMode.mobile, mMode.password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Account>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e("LoginPresenter", "===onSubscribe===");

                            }

                            @Override
                            public void onNext(Account o) {
                                Log.e("LoginPresenter", "===onNext===");
                                Gson gson = new Gson();
                                Log.e("LoginPresenter", "===onNext===" + gson.toJson(o));
                                RxBus.getInstance().post(new LoginEvent(0));
                                mActivity.finish();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("LoginPresenter", "===onError===" + e.toString());

                            }

                            @Override
                            public void onComplete() {
                                Log.e("LoginPresenter", "===onComplete===");

                            }
                        });
            }

        } else if (v.getId() == R.id.imgClose) {
            RxBus.getInstance().post(new LoginEvent(-1));
            mActivity.finish();
        }
    }

    private boolean validate(LoginModel mMode) {
        if (mMode == null)
            return false;

        if (mMode.mobile == null || mMode.mobile.length() == 0)
            return false;

        if (mMode.password == null || mMode.password.length() == 0)
            return false;

        Log.e("LoginPresenter", "mobile==" + mMode.mobile + ";password==" + mMode.password);
        return true;
    }
}
