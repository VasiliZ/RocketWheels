package com.github.vasiliz.rocketswheel.userVkNews.presenter;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.userVkNews.model.UserVkNewsModel;
import com.github.vasiliz.rocketswheel.userVkNews.view.IUserVkNewsView;
import com.github.vasiliz.rokets.RocketPresenter;

public class UserVkNewsPresenter extends RocketPresenter<IUserVkNewsView> implements IUserVkNewsPresenter {

    private IUserVkNewsView mUserVkNewsView;
    private final UserVkNewsModel mUserVkNewsModel;

    public UserVkNewsPresenter(final UserVkNewsModel pUserVkNewsModel) {
        mUserVkNewsModel = pUserVkNewsModel;
    }

    @Override
    public void attachView(@NonNull final IUserVkNewsView pView) {
        mUserVkNewsView = pView;
    }

    @Override
    public void parseData(final String url) {
        mUserVkNewsModel.getNewsVk(url, pParseNews ->
                mUserVkNewsView.setDataNews(pParseNews));
    }



}
