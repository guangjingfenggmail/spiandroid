package com.open.usermodule.login

import android.app.Activity
import android.util.Log
import android.view.View

import androidx.fragment.app.FragmentActivity

import com.google.gson.Gson
import com.open.aspectjx.DoubleClick
import com.open.jetpack.Presenter
import com.open.jetpack.livedata.LiveDataBus
import com.open.usermodule.R
import com.open.usermodule.event.LiveLoginEvent
import com.open.usermodule.service.room.user.User

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

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
public open class LoginPresenter(context: FragmentActivity, model: LoginModel, viewModel: LoginViewModel) : Presenter<LoginModel, LoginViewModel>(context, model, viewModel) {

    @DoubleClick(value = 1000)
    fun onClick(v: View, mMode: LoginModel) {
        if (v.id == R.id.btnSubmit) {
            if (validate(mMode)) {
                val user = User()
                user.name = mMode.mobile
                user.mobile = mMode.mobile
                user.pwd = mMode.password
                user.createDate = System.currentTimeMillis().toString() + ""
                user.updateDate = System.currentTimeMillis().toString() + ""
                viewModel.insert(user)
                viewModel.mLoginRepertory.signUp(mMode.mobile, mMode.password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : Observer<Account> {
                            override fun onSubscribe(d: Disposable) {
                                Log.e("LoginPresenter", "===onSubscribe===")

                            }

                            override fun onNext(o: Account) {
                                Log.e("LoginPresenter", "===onNext===")
                                val gson = Gson()
                                Log.e("LoginPresenter", "===onNext===" + gson.toJson(o))

                            }

                            override fun onError(e: Throwable) {
                                Log.e("LoginPresenter", "===onError===$e")

                            }

                            override fun onComplete() {
                                Log.e("LoginPresenter", "===onComplete===")
                                //                                RxBus.getInstance().post(new LoginEvent(0));
                                LiveDataBus.get().of(LiveLoginEvent::class.java).login().postValue(0)
                                (context as Activity).finish()
                            }
                        })
            }

        } else if (v.id == R.id.imgClose) {
            //            RxBus.getInstance().post(new LoginEvent(-1));
            LiveDataBus.get().of(LiveLoginEvent::class.java).login().postValue(-1)
            (context as Activity).finish()
        }
    }


    fun onTextChanged(mMode: LoginModel, s: CharSequence, start: Int, before: Int, count: Int) {
        Log.e("LoginPresenter", "===onTextChanged=== s$s")
        viewModel.mloginLiveData.postValue(mMode)

    }

    private fun validate(mMode: LoginModel?): Boolean {
        if (mMode == null)
            return false

        if (mMode.mobile == null || mMode.mobile.length == 0)
            return false

        if (mMode.password == null || mMode.password.length == 0)
            return false

        Log.e("LoginPresenter", "mobile==" + mMode.mobile + ";password==" + mMode.password)
        return true
    }
}
