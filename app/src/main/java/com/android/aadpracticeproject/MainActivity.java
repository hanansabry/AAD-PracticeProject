package com.android.aadpracticeproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.aadpracticeproject.domain.viewmodels.LeaderBoardViewModel;
import com.android.aadpracticeproject.domain.viewmodels.factory.LeaderBoardViewModelFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_toolbar_for_main_activity);

        LeaderBoardViewModel leaderBoardViewModel =
                ViewModelProviders.of(this, new LeaderBoardViewModelFactory(Injection.getLeaderBoardRepository()))
                        .get(LeaderBoardViewModel.class);

        leaderBoardViewModel.getLearningLeaders();
        leaderBoardViewModel.getSkillIqLeaders();

        leaderBoardViewModel.learningLeadersLearners.observe(this, learners -> {
            Log.d("First, ", "Learning Leaders size = " + learners.size());
        });

        leaderBoardViewModel.skillIqLearners.observe(this, learners -> {
            Log.d("Second", "Skill Iq learners size = " + learners.size());
        });


    }

    public void onSubmitClicked(View view) {
        startActivity(new Intent(this, SubmitActivity.class));
    }
}