package com.android.aadpracticeproject.presentation.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.aadpracticeproject.Injection;
import com.android.aadpracticeproject.R;
import com.android.aadpracticeproject.databinding.ActivitySubmitBinding;
import com.android.aadpracticeproject.domain.viewmodels.SubmitFormViewModel;
import com.android.aadpracticeproject.domain.viewmodels.factory.SubmissionViewModelFactory;
import com.android.aadpracticeproject.presentation.widgets.ConfirmDialog;
import com.android.aadpracticeproject.presentation.widgets.FailedDialog;
import com.android.aadpracticeproject.presentation.widgets.SuccessDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class SubmitActivity extends AppCompatActivity {

    private SubmitFormViewModel submissionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySubmitBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_submit);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_toolbar_for_submit_activity);

        submissionViewModel =
                ViewModelProviders.of(this, new SubmissionViewModelFactory(Injection.getSubmissionRepository()))
                        .get(SubmitFormViewModel.class);
        binding.setModel(submissionViewModel);
        binding.setLifecycleOwner(this);

        submissionViewModel.getIsValidObserver().observe(this, response -> {
            new ConfirmDialog(this, submissionViewModel).show();
        });

        submissionViewModel.getResponse().observe(this, response -> {
            if (response == 1) {
                Toast.makeText(this, "Submission Successful", Toast.LENGTH_SHORT).show();
                new SuccessDialog(this).show();
            } else {
                Toast.makeText(this, "Submission not Successful", Toast.LENGTH_SHORT).show();
                new FailedDialog(this).show();
            }
        });

    }

    public void onBackClicked(View view) {
        onBackPressed();
    }

    public void onSubmitClicked(View view) {
        submissionViewModel.validateData();
    }
}