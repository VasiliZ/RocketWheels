package com.github.vasiliz.rocketswheel.userVkNews.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.userVkNews.common.VkNewsAdapter;
import com.github.vasiliz.rocketswheel.userVkNews.model.UserVkNewsModel;
import com.github.vasiliz.rocketswheel.userVkNews.presenter.UserVkNewsPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

public class UserVkNewsView extends RocketActivity implements IUserVkNewsView {

    private UserVkNewsPresenter mUserVkNewsPresenter;
    private RecyclerView mRecyclerView;
    private ParseNews mParseNews;
    private String url = "https://api.vk.com/method/newsfeed.get?filters=post&end_time&access_token=f69166c6a7a4e7d7f1a772f46e1b6164c621a220af64de0fe64afdc8f67abff2f96f511a00a2b1115dc6f";

    @Override
    public void setDataNews(final ParseNews pParseNews) {
       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        VkNewsAdapter vkNewsAdapter = new VkNewsAdapter(this, pParseNews.getResponse().getGroups());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(vkNewsAdapter);
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

    public void init() {
        mRecyclerView = findViewById(R.id.news_recycler_view);
        mUserVkNewsPresenter.parseData(url);
    }
}
