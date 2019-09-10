package com.open.usermodule.login;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.google.gson.Gson;
import com.open.aspectjx.DoubleClick;
import com.open.event.LoginEvent;
import com.open.jetpack.Presenter;
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
public class LoginPresenter extends Presenter<LoginModel,LoginViewModel> {

    public LoginPresenter(FragmentActivity context, LoginModel model, LoginViewModel viewModel) {
        super(context, model, viewModel);
    }

    @DoubleClick(value = 1000)
    public void onClick(View v, LoginModel mMode) {
        if (v.getId() == R.id.btnSubmit) {
            if (validate(mMode)) {
                viewModel.mLoginRepertory.signUp(mMode.mobile, mMode.password)
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

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("LoginPresenter", "===onError===" + e.toString());

                            }

                            @Override
                            public void onComplete() {
                                Log.e("LoginPresenter", "===onComplete===");
                                RxBus.getInstance().post(new LoginEvent(0));
                                ((Activity)context).finish();
                            }
                        });
            }

        } else if (v.getId() == R.id.imgClose) {
            RxBus.getInstance().post(new LoginEvent(-1));
            ((Activity)context).finish();
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
