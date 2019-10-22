package com.open.usermodule.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer

import com.open.jetpack.AbsFragment
import com.open.usermodule.R
import com.open.usermodule.databinding.FragmentLoginBinding

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
class LoginFragment : AbsFragment<FragmentLoginBinding, LoginModel, LoginViewModel, LoginPresenter>() {
    private var btnSubmit: Button? = null

    override fun setLayout(): Int {
        return R.layout.fragment_login
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initProvider(LoginViewModel::class.java)

        btnSubmit = view.findViewById(R.id.btnSubmit)
    }


    override fun setBinding() {
        mPresenter = LoginPresenter(activity!!, LoginModel("",""), mViewModel)
        mModel = LoginModel("", "")

        mBinding.presenter = mPresenter
        mBinding.model = mModel

        mViewModel.init();

        mViewModel.mloginLiveData.observe(this, Observer { loginModel ->
            Log.e("LoginFragment", "===onChanged===")
            if (loginModel.password.length > 0 && loginModel.mobile.length > 0) {
                mModel.isEnable = true
            } else {
                mModel.isEnable = false
            }
            btnSubmit!!.isEnabled = mModel.isEnable
        })
    }
}
