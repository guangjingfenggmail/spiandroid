package com.open.usermodule.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initProvider(LoginViewModel.class);
    }


    @Override
    protected void setBinding() {
        mPresenter = new LoginPresenter(getActivity(), null, mViewModel);
        mModel = new LoginModel("1111", "11111");

        mBinding.setPresenter(mPresenter);
        mBinding.setModel(mModel);
    }
}
