package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.github.vasiliz.rocketswheel.R;

public class LoadingViewHolder extends RecyclerView.ViewHolder {

    private ProgressBar mProgressBar;

    public LoadingViewHolder(final View itemView) {
        super(itemView);

        mProgressBar = itemView.findViewById(R.id.load_progress_bar);
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public void setProgressBar(final ProgressBar pProgressBar) {
        mProgressBar = pProgressBar;
    }
}
