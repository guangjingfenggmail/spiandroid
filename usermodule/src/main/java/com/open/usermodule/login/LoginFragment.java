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
public class LoginFragment extends Fragment {
    private FragmentLoginBinding mBinding;
    private LoginViewModel mViewModel;
    private LoginPresenter mPresenter;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        mBinding = FragmentLoginBinding.inflate(inflater);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(LoginViewModel.class);
        LoginModel mModel = new LoginModel("1111", "11111");
        mPresenter = new LoginPresenter(getActivity(),mViewModel);
        mBinding.setPresenter(mPresenter);
        mBinding.setModel(mModel);
    }
}
