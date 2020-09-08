package com.android.aadpracticeproject.presentation.widgets;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.aadpracticeproject.R;
import com.android.aadpracticeproject.domain.viewmodels.SubmitFormViewModel;

import androidx.annotation.NonNull;

public class ConfirmDialog extends Dialog {

    private SubmitFormViewModel viewModel;

    public ConfirmDialog(@NonNull Context context, SubmitFormViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirm_dialog);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageButton dismissButton = findViewById(R.id.dismissBtn);
        dismissButton.setOnClickListener(v -> dismiss());

        Button yesButton = findViewById(R.id.yesButton);
        yesButton.setOnClickListener(v -> {
            viewModel.onSubmitClicked();
            dismiss();
        });
    }
}
