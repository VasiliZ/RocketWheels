package com.github.vasiliz.rocketswheel.userVkNews.view;

import android.app.Application;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.userVkNews.model.UserVkNewsModel;
import com.github.vasiliz.rocketswheel.userVkNews.presenter.UserVkNewsPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

import java.util.concurrent.TimeUnit;

public class UserVkNewsView extends RocketActivity implements IUserVkNewsView {

    private UserVkNewsPresenter mUserVkNewsPresenter;
    private ImageView showUserNews;
    private UserNewsFragment mFragmentUserNews;
    private FragmentTransaction mFragmentTransaction;

    @Override
    public void setDataNews(final ParseNews pParseNews) {

    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected RocketPresenter injectPresenter(final Application pApplication) {
        mUserVkNewsPresenter = new UserVkNewsPresenter(new UserVkNewsModel());
        return mUserVkNewsPresenter;
    }

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.layout_vk_news);
        init();
    }

    private void init() {

        showUserNews = findViewById(R.id.display_news_image_view);

        createUserNewsFragment();
        showUserNews.setOnClickListener(v -> {
            switch (v.getId()) {
                case R.id.display_news_image_view:
                    showUserNews.setImageResource(R.drawable.user_news_selected);
                    replFragment();
            }
        });

    }

    @Override
    public void showProgress() {

    }

    //todo add this method for model #2
    @Override
    public void hideProgress() {

    }

    public void createUserNewsFragment() {

        showUserNews.setImageResource(R.drawable.user_news_selected);
        mFragmentUserNews = new UserNewsFragment();
        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.news_fragment, mFragmentUserNews);
        mFragmentTransaction.commit();

    }

    public void replFragment() {
        FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.detach(mFragmentUserNews);
        fragTransaction.attach(mFragmentUserNews);
        fragTransaction.commit();
    }
}

