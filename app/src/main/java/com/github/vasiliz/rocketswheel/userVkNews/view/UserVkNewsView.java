package com.github.vasiliz.rocketswheel.userVkNews.view;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.commons.ConstantsStrings;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;
import com.github.vasiliz.rocketswheel.tasks.NewNewsVk;
import com.github.vasiliz.rocketswheel.userVkNews.common.NewsContentAdapter;
import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;
import com.github.vasiliz.rocketswheel.userVkNews.model.UserVkNewsModel;
import com.github.vasiliz.rocketswheel.userVkNews.presenter.UserVkNewsPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

import java.util.Iterator;
import java.util.List;

public class UserVkNewsView extends RocketActivity implements IUserVkNewsView {

    public static final String API_VK_VERSION = "&v=5.69";
    public static final String TAG = "1";
    public static final String ACCESS_TOKEN = "&access_token=";
    private UserVkNewsPresenter mUserVkNewsPresenter;
    private RecyclerView mRecyclerView;
    private ImageView mShowUserNews;
    private boolean mFlag = true;
    private ProgressDialog mProgressDialog;
    private ParseNews mParseNews;
    private NewsContentAdapter mNewsContentAdapter;

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
        mShowUserNews = findViewById(R.id.display_news_image_view);
        mRecyclerView = findViewById(R.id.news_recycler_view);
        String s = ConstantsStrings.GET_USER_NEWS_URL + getToken() + API_VK_VERSION;
        mUserVkNewsPresenter.parseData(ConstantsStrings.GET_USER_NEWS_URL + getToken() + API_VK_VERSION);
        //   mUserVkNewsPresenter.parseData("https://api.vk.com/method/newsfeed.get?filters=post&end_time&access_token=f69166c6a7a4e7d7f1a772f46e1b6164c621a220af64de0fe64afdc8f67abff2f96f511a00a2b1115dc6f&v=5.69");

        //    mShowUserNews.setOnClickListener(v ->

    }

    private String getToken() {
        final SharedPreferences sharedPreferences = getSharedPreferences(ConstantsStrings.APP_PREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(ConstantsStrings.APP_TOKEN_NAME, "");
    }

    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "", getResources().getString(R.string.wait));
    }

    //todo add this method for model #2
    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void setDataNews(final ParseNews pParseNews) {

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mParseNews = pParseNews;
        mNewsContentAdapter = new NewsContentAdapter(this, pParseNews);
        linearLayoutManager.canScrollVertically();
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mNewsContentAdapter);
        mNewsContentAdapter.setOnLoadMoreCallBack(new NewsContentAdapter.OnLoadMoreCallback() {

            @Override
            public void onLoadMore() {
                mRecyclerView.post(new Runnable() {

                    @Override
                    public void run() {
                        addNewItem();

                        getNewData(ConstantsStrings.NEW_NEWS_API_METOD + mParseNews.getResponse().getNextScopeNews() + ACCESS_TOKEN + getToken() + API_VK_VERSION, new ParseCallBack() {

                            @Override
                            public void isParsed(final ParseNews pParseNews) {
                                mParseNews.getResponse().getItems().remove(mParseNews.getResponse().getItems().size() - 1);
                                mNewsContentAdapter.notifyItemRemoved(mParseNews.getResponse().getItems().size());

                                List<Group> groups = pParseNews.getResponse().getGroups();
                                List<Profiles> profiles = pParseNews.getResponse().getProfiles();
                                Iterator<Group> iteratorGroup = groups.iterator();
                                Iterator<Profiles> profilesIterator = profiles.iterator();

                                for (int i = 0; i < mParseNews.getResponse().getGroups().size(); i++) {

                                    while (iteratorGroup.hasNext()) {
                                        Group group = iteratorGroup.next();

                                        if (mParseNews.getResponse().getGroups().get(i).getGid() == group.getGid()) {
                                            iteratorGroup.remove();
                                            Log.d(TAG, "isParsed: " + group.getGid());
                                        }
                                    }
                                }

                                for (int i = 0; i < groups.size(); i++) {
                                    mParseNews.getResponse().getGroups().add(groups.get(i));
                                }

                                for (int i = 0; i < mParseNews.getResponse().getGroups().size(); i++) {
                                    while (profilesIterator.hasNext()) {
                                        Profiles profiles1 = profilesIterator.next();

                                        if (mParseNews.getResponse().getProfiles().get(i).getUid() == profiles1.getUid()) {
                                            profilesIterator.remove();
                                            Log.d(TAG, "isParsed: " + profiles1.getUid());
                                        }
                                    }
                                }

                                for (int i = 0; i < profiles.size(); i++){
                                    mParseNews.getResponse().getProfiles().add(profiles.get(i));
                                }

                                {
                                    for (int i = 0; i < pParseNews.getResponse().getItems().size(); i++) {
                                        mParseNews.getResponse().getItems().add(pParseNews.getResponse().getItems().get(i));
                                    }
                                }
                                mParseNews.getResponse().setNextScopeNews(pParseNews.getResponse().getNextScopeNews());
                                mParseNews.getResponse().getItems().remove(mParseNews.getResponse().getItems().size() - 1);
                                mNewsContentAdapter.notifyDataChanged();
                            }
                        });

                    }

                });
            }

        });

    }

    private void getNewData(final String pUrl, ParseCallBack pParseCallBack) {

        NewNewsVk newNewsVk = new NewNewsVk(pParseCallBack);
        newNewsVk.execute(pUrl);
    }

    public void addNewItem() {
        Item item = new Item();
        item.setType("load");
        mParseNews.getResponse().getItems().add(item);
        mNewsContentAdapter.notifyItemInserted(mParseNews.getResponse().getItems().size());
    }

}

