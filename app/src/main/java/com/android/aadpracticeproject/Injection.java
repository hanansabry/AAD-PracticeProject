package com.android.aadpracticeproject;

import com.android.aadpracticeproject.data.repositories.LeaderBoardRepositoryImpl;
import com.android.aadpracticeproject.data.repositories.SubmissionRepositoryImpl;
import com.android.aadpracticeproject.domain.repositories.LeaderBoardRepository;
import com.android.aadpracticeproject.domain.repositories.SubmissionRepository;

public class Injection {
    public static LeaderBoardRepository getLeaderBoardRepository() {
        return new LeaderBoardRepositoryImpl();
    }

    public static SubmissionRepository getSubmissionRepository() {
        return new SubmissionRepositoryImpl();
    }
}
