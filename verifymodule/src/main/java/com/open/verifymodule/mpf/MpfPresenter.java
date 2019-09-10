package com.open.verifymodule.mpf;

import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.open.aspectjx.DoubleClick;
import com.open.jetpack.Presenter;
import com.open.verifymodule.R;
import com.open.verifymodule.verify.mpf.AgreementHandler;
import com.open.verifymodule.verify.mpf.FacialHandler;
import com.open.verifymodule.verify.mpf.RejectHandler;
import com.open.verifymodule.verify.mpf.TriggerHandler;
import com.open.verifymodule.verify.mpf.VerifyInfoHandler;

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
            VerifyInfoHandler verifyInfoHandler = new VerifyInfoHandler(context, context.getIntent().getExtras());
            FacialHandler facialHandler = new FacialHandler(context, context.getIntent().getExtras());
            TriggerHandler triggerHandler = new TriggerHandler(context, context.getIntent().getExtras());
            RejectHandler rejectHandler = new RejectHandler(context, context.getIntent().getExtras());
            AgreementHandler agreementHandler = new AgreementHandler(context, context.getIntent().getExtras());

            verifyInfoHandler.setNext(facialHandler);
            facialHandler.setNext(triggerHandler);
            triggerHandler.setNext(rejectHandler);
            rejectHandler.setNext(agreementHandler);

        }
    }
}
