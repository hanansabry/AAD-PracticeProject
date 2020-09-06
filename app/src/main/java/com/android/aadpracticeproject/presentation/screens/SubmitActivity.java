package com.android.aadpracticeproject.presentation.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.aadpracticeproject.Injection;
import com.android.aadpracticeproject.R;
import com.android.aadpracticeproject.databinding.ActivitySubmitBinding;
import com.android.aadpracticeproject.domain.viewmodels.SubmitFormViewModel;
import com.android.aadpracticeproject.domain.viewmodels.factory.SubmissionViewModelFactory;

public class SubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySubmitBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_submit);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_toolbar_for_submit_activity);

        SubmitFormViewModel submissionViewModel =
                ViewModelProviders.of(this, new SubmissionViewModelFactory(Injection.getSubmissionRepository()))
                        .get(SubmitFormViewModel.class);
        binding.setModel(submissionViewModel);
        binding.setLifecycleOwner(this);

        submissionViewModel.response.observe(this, response -> {
            if (response == 1) {
                Toast.makeText(this, "Submission Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Submission not Successful", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onBackClicked(View view) {
        onBackPressed();
    }
}