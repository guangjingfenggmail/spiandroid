package com.open.usermodule.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.open.jetpack.AbsFragment;
import com.open.usermodule.R;
import com.open.usermodule.databinding.FragmentLoginBinding;

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
public class LoginFragment extends AbsFragment<FragmentLoginBinding, LoginModel, LoginViewModel, LoginPresenter> {
    private Button btnSubmit;

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initProvider(LoginViewModel.class);

        btnSubmit = view.findViewById(R.id.btnSubmit);
    }


    @Override
    protected void setBinding() {
        mPresenter = new LoginPresenter(getActivity(), null, mViewModel);
        mModel = new LoginModel("", "");

        mBinding.setPresenter(mPresenter);
        mBinding.setModel(mModel);

        mViewModel.mloginLiveData.observe(this, new Observer<LoginModel>() {
            @Override
            public void onChanged(LoginModel loginModel) {
                Log.e("LoginFragment", "===onChanged===");
                if (loginModel.password.length() > 0 && loginModel.mobile.length() > 0) {
                    mModel.isEnable = true;
                } else {
                    mModel.isEnable = false;
                }
                btnSubmit.setEnabled(mModel.isEnable);
            }
        });
    }
}
