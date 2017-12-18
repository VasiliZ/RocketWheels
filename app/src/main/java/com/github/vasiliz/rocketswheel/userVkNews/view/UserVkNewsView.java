package com.github.vasiliz.rocketswheel.userVkNews.view;

import android.app.Application;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.userMesseger.UserMessengerFragment;
import com.github.vasiliz.rocketswheel.userVkNews.model.UserVkNewsModel;
import com.github.vasiliz.rocketswheel.userVkNews.presenter.UserVkNewsPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

//TODO if class extend activity it should have name ....Activity
public class UserVkNewsView extends RocketActivity implements IUserVkNewsView {

    private UserVkNewsPresenter mUserVkNewsPresenter;
    private ImageView mShowUserNews;
    private ImageView mShowMessages;
    private UserNewsFragment mFragmentUserNews;
    private UserMessengerFragment mUserMessengerFragment;
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

        mShowUserNews = findViewById(R.id.display_news_image_view);
        mShowMessages = findViewById(R.id.user_message);
        mFragmentUserNews = new UserNewsFragment();
        mUserMessengerFragment = new UserMessengerFragment();

        mFragmentTransaction = getFragmentManager().beginTransaction();
//        mShowUserNews.setImageResource(R.drawable.user_news_selected);
        mFragmentTransaction.add(R.id.fragment_container, mFragmentUserNews);
        mFragmentTransaction.commit();


        mShowUserNews.setOnClickListener(replacedFragments);
        mShowMessages.setOnClickListener(replacedFragments);

    }

    @Override
    public void showProgress() {

    }

    //todo add this method for model #2
    @Override
    public void hideProgress() {

    }

    private View.OnClickListener replacedFragments = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            mFragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()) {
                case R.id.display_news_image_view:
                    mFragmentTransaction = getFragmentManager().beginTransaction();
//                    mShowUserNews.setImageResource(R.drawable.user_news_selected);
                    mFragmentTransaction.replace(R.id.fragment_container, mFragmentUserNews);
                    mFragmentTransaction.commit();
                    break;
                case R.id.user_message:
                    mFragmentTransaction = getFragmentManager().beginTransaction();
                    mFragmentTransaction.replace(R.id.fragment_container, mUserMessengerFragment);
                    mFragmentTransaction.commit();
                    break;
            }
        }
    };
}

