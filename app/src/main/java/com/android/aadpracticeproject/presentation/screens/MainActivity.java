package com.android.aadpracticeproject.presentation.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.aadpracticeproject.Injection;
import com.android.aadpracticeproject.R;
import com.android.aadpracticeproject.domain.viewmodels.LeaderBoardViewModel;
import com.android.aadpracticeproject.domain.viewmodels.factory.LeaderBoardViewModelFactory;
import com.android.aadpracticeproject.presentation.adapters.LearnersAdapter;
import com.android.aadpracticeproject.presentation.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LearnersAdapter learnersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPagerAndTabLayout();
    }

    private void initViewPagerAndTabLayout() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(ViewPagerAdapter.NUM_OF_FRAGMENTS);
        tabLayout = findViewById(R.id.tabs);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onSubmitClicked(View view) {
        startActivity(new Intent(this, SubmitActivity.class));
    }
}