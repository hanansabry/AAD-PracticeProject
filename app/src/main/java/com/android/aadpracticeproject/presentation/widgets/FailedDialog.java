package com.android.aadpracticeproject.presentation.widgets;

import android.content.Context;

import com.android.aadpracticeproject.R;

import androidx.annotation.NonNull;

public class FailedDialog extends BaseDialog {
    public FailedDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getViewId() {
        return R.layout.failed_dialog;
    }
}
