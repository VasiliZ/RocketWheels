package com.github.vasiliz.rocketswheel.tasks;

import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.models.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.services.httpService.HttpService;
import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class
ParseUserNewsTask extends AsyncTask<String, Void, ParseNews> {

    private ParseCallBack mICompliteCallBack;
    private ParseNews mParseNews;
    private HttpService mHttpService;

    public ParseUserNewsTask(final ParseCallBack pICompliteCallBack) {
        mICompliteCallBack = pICompliteCallBack;
    }

    @Override
    protected ParseNews doInBackground(final String... pStrings) {
        mHttpService = new HttpService();
        String sourse = pStrings[0];
        final Gson gson = new GsonBuilder().create();
        mParseNews = gson.fromJson(mHttpService.request(sourse), ParseNews.class);
        return mParseNews;
    }

    @Override
    protected void onPostExecute(final ParseNews pParseNews) {
        super.onPostExecute(pParseNews);

        if (mICompliteCallBack != null) {
            mICompliteCallBack.getNews(pParseNews);

        }
    }
}
