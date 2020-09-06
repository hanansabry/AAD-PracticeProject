package com.android.aadpracticeproject.presentation.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.aadpracticeproject.Injection;
import com.android.aadpracticeproject.R;
import com.android.aadpracticeproject.data.models.Learner;
import com.android.aadpracticeproject.domain.viewmodels.LeaderBoardViewModel;
import com.android.aadpracticeproject.domain.viewmodels.factory.LeaderBoardViewModelFactory;
import com.android.aadpracticeproject.presentation.adapters.LearnersAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LearnerFragment extends Fragment {

    private RecyclerView learnersRecyclerView;
    private LearnersAdapter learnersAdapter;

    public static LearnerFragment newInstance(String type) {
        LearnerFragment fragment = new LearnerFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learner_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String type = getArguments().getString("type");

        learnersRecyclerView = view.findViewById(R.id.learners_recylerview);
        learnersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //retrieve learners data
        LeaderBoardViewModel leaderBoardViewModel =
                ViewModelProviders.of(this, new LeaderBoardViewModelFactory(Injection.getLeaderBoardRepository()))
                        .get("leaders", LeaderBoardViewModel.class);

        if (type.equals(Learner.LearnerType.Leader.name())) {
            leaderBoardViewModel.getLearningLeaders();
        } else if (type.equals(Learner.LearnerType.SkillIq.name())) {
            leaderBoardViewModel.getSkillIqLeaders();
        }

        leaderBoardViewModel.learningLeadersLearners.observe(this, learners -> {
            learnersAdapter = new LearnersAdapter(learners, Learner.LearnerType.Leader.name());
            learnersRecyclerView.setAdapter(learnersAdapter);
            learnersAdapter.notifyDataSetChanged();
        });

        leaderBoardViewModel.skillIqLearners.observe(this, learners -> {
            learnersAdapter = new LearnersAdapter(learners, Learner.LearnerType.SkillIq.name());
            learnersRecyclerView.setAdapter(learnersAdapter);
            learnersAdapter.notifyDataSetChanged();
        });
    }
}