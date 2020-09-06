package com.android.aadpracticeproject.presentation.adapters;

import com.android.aadpracticeproject.data.models.Learner;
import com.android.aadpracticeproject.presentation.screens.LearnerFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_OF_FRAGMENTS = 2;
    private TabLayout tabLayout;

    public ViewPagerAdapter(FragmentManager manager, TabLayout tabLayout) {
        super(manager);
        this.tabLayout = tabLayout;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = LearnerFragment.newInstance(Learner.LearnerType.Leader.name());
        } else if (position == 1) {
            fragment = LearnerFragment.newInstance(Learner.LearnerType.SkillIq.name());
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_OF_FRAGMENTS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Learning Leaders";
        } else if (position == 1) {
            title = "Skill IQ Leaders";
        }
        return title;
    }


}
