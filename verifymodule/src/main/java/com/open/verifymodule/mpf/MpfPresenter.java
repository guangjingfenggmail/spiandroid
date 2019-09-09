package com.open.verifymodule.mpf;

import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.open.aspectjx.DoubleClick;
import com.open.jetpack.Presenter;
import com.open.verifymodule.R;

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
public class MpfPresenter extends Presenter<MpfModel, MpfViewModel> {

    public MpfPresenter(FragmentActivity context, MpfModel model, MpfViewModel viewModel) {
        super(context, model, viewModel);
    }

    @DoubleClick(value = 1000)
    public void onClick(View v) {
        if (v.getId() == R.id.btnActivate) {

        }
    }
}
