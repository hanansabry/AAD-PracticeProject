package com.android.aadpracticeproject.presentation.widgets;

import android.content.Context;

import com.android.aadpracticeproject.R;

import androidx.annotation.NonNull;

public class SuccessDialog extends BaseDialog {
    public SuccessDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getViewId() {
        return R.layout.success_dialog;
    }
}
