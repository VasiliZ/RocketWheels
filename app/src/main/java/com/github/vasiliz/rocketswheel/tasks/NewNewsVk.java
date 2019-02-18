package com.github.vasiliz.rocketswheel.tasks;

import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.imagesLoader.streams.HttpInputStreamProvider;
import com.github.vasiliz.rocketswheel.models.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.services.httpService.HttpService;
import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NewNewsVk extends AsyncTask<String, Void, ParseNews> {

    private final ParseCallBack mParseCallBack;

    public NewNewsVk(final ParseCallBack pParseCallBack) {

        mParseCallBack = pParseCallBack;

    }

    @Override
    protected ParseNews doInBackground(final String... pStrings) {
        String json = null;
        try {
            InputStream inputStream = new HttpInputStreamProvider().get(pStrings[0]);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());

            final byte[] part = new byte[1 << 16];
            int bytesForReading;

            while ((bytesForReading = inputStream.read(part)) > 0) {
                byteArrayOutputStream.write(part, 0, bytesForReading);
            }
            final byte[] bytes = byteArrayOutputStream.toByteArray();

            json = new String(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        final Gson gson = new GsonBuilder().create();
        ParseNews parseNews = null;
        if (json != null) {
            parseNews = gson.fromJson(json, ParseNews.class);
        }

        return parseNews;
    }

    @Override
    protected void onPostExecute(final ParseNews pParseNews) {
        super.onPostExecute(pParseNews);

        if (mParseCallBack != null) {
            mParseCallBack.getNews(pParseNews);
        }
    }
}
