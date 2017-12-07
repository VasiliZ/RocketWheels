package com.github.vasiliz.rocketswheel.userVkNews.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vasiliz.rocketswheel.R;

public class UserNewsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment, null);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
    }
}
