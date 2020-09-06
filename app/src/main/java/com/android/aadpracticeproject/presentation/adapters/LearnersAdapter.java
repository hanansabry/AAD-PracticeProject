package com.android.aadpracticeproject.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.aadpracticeproject.R;
import com.android.aadpracticeproject.data.models.Learner;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LearnersAdapter extends RecyclerView.Adapter<LearnersAdapter.LearnerViewHolder> {

    private List<Learner> learners;
    private String type;

    public LearnersAdapter(List<Learner> learners, String type) {
        this.learners = learners;
        this.type = type;
    }

    @NonNull
    @Override
    public LearnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.learner_item_view, parent, false);
        return new LearnerViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull LearnerViewHolder holder, int position) {
        Learner learner = learners.get(position);
        holder.setData(learner);
    }

    @Override
    public int getItemCount() {
        return learners.size();
    }

    class LearnerViewHolder extends RecyclerView.ViewHolder {

        private TextView fullNameTextView;
        private TextView detailsTextView;
        private ImageView badgeImageView;
        private Context context;

        public LearnerViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            fullNameTextView = itemView.findViewById(R.id.fullNameTextView);
            detailsTextView = itemView.findViewById(R.id.detailsTextView);
            badgeImageView = itemView.findViewById(R.id.badgeImageView);
        }

        public void setData(Learner learner) {
            String details = null;
            if (type.equals(Learner.LearnerType.Leader.name())) {
                details = String.format(Locale.US, "%1$d learning hours, %2$s.", learner.getValue(), learner.getCountry());
            } else if (type.equals(Learner.LearnerType.SkillIq.name())) {
                details = String.format(Locale.US, "%1$d skill IQ Score, %2$s.", learner.getValue(), learner.getCountry());
            }

            fullNameTextView.setText(learner.getName());
            detailsTextView.setText(details);
            Picasso.with(context).load(learner.getBadgeUrl()).into(badgeImageView);
        }
    }
}
