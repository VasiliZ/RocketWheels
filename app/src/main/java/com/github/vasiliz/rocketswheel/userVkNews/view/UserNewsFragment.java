package com.github.vasiliz.rocketswheel.userVkNews.view;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vasiliz.rocketswheel.MyApp;
import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.commons.ConstantsStrings;
import com.github.vasiliz.rocketswheel.db.SqlConnector;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;
import com.github.vasiliz.rocketswheel.tasks.NewNewsVk;
import com.github.vasiliz.rocketswheel.userVkNews.common.NewsContentAdapter;
import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;
import com.github.vasiliz.rocketswheel.userVkNews.model.UserVkNewsModel;
import com.github.vasiliz.rocketswheel.utils.ContextHolder;

import java.util.Iterator;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class UserNewsFragment extends Fragment implements IUserVkNewsView {

    public static final String API_VK_VERSION = "&v=5.69";
    public static final String TAG = "1";
    public static final String ACCESS_TOKEN = "&access_token=";

    private SqlConnector sqlConnector;
    private RecyclerView mRecyclerView;
    private boolean mFlag = true;
    private ParseNews mParseNews;
    private NewsContentAdapter mNewsContentAdapter;



    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SQLiteDatabase sqLiteDatabase = new SqlConnector(ContextHolder.getContext()).getWritableDatabase();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        View viewNews = inflater.inflate(R.layout.news_fragment, null);


        mRecyclerView = viewNews.findViewById(R.id.news_recycler_view);
        parseData(ConstantsStrings.GET_USER_NEWS_URL + getToken() + API_VK_VERSION);

        return viewNews;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
    }

    @Override
    public void handleError(final Throwable pThrowable) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    private String getToken() {
        final SharedPreferences sharedPreferences = ContextHolder.getContext().getSharedPreferences(ConstantsStrings.APP_PREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(ConstantsStrings.APP_TOKEN_NAME, "");
    }

    public void setDataNews(final ParseNews pParseNews) {

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContextHolder.getContext());
        mParseNews = pParseNews;
        mNewsContentAdapter = new NewsContentAdapter(ContextHolder.getContext(), pParseNews);
        linearLayoutManager.canScrollVertically();
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mNewsContentAdapter);
        mNewsContentAdapter.setOnLoadMoreCallBack(() -> mRecyclerView.post(() -> {
            addNewItem();

            getNewData(ConstantsStrings.NEW_NEWS_API_METHOD + mParseNews.getResponse().getNextScopeNews() + ACCESS_TOKEN + getToken() + API_VK_VERSION, new ParseCallBack() {

                @Override
                public void isParsed(final ParseNews pParseNews1) {
                    mParseNews.getResponse().getItems().remove(mParseNews.getResponse().getItems().size() - 1);
                    mNewsContentAdapter.notifyItemRemoved(mParseNews.getResponse().getItems().size());

                    //TODO move to background thread.
                    //TODO you can use CHARLES or FIDDLER
                    List<Group> groups = pParseNews1.getResponse().getGroups();
                    List<Profiles> profiles = pParseNews1.getResponse().getProfiles();
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

                    for (int i = 0; i < profiles.size(); i++) {
                        mParseNews.getResponse().getProfiles().add(profiles.get(i));
                    }

                    {
                        for (int i = 0; i < pParseNews1.getResponse().getItems().size(); i++) {
                            mParseNews.getResponse().getItems().add(pParseNews1.getResponse().getItems().get(i));
                        }
                    }
                    mParseNews.getResponse().setNextScopeNews(pParseNews1.getResponse().getNextScopeNews());
                    mParseNews.getResponse().getItems().remove(mParseNews.getResponse().getItems().size() - 1);
                    mNewsContentAdapter.notifyDataChanged();
                }
            });

        }));

    }

    private void getNewData(final String pUrl, ParseCallBack pParseCallBack) {

        final NewNewsVk newNewsVk = new NewNewsVk(pParseCallBack);
        newNewsVk.execute(pUrl);
    }

    public void addNewItem() {
        Item item = new Item();
        item.setType("load");
        mParseNews.getResponse().getItems().add(item);
        mNewsContentAdapter.notifyItemInserted(mParseNews.getResponse().getItems().size());
    }

    public void parseData(String pUrl) {
        UserVkNewsModel userVkNewsModel = new UserVkNewsModel();
        userVkNewsModel.getNewsVk(pUrl, pParseNews -> setDataNews(pParseNews));
    }
}
