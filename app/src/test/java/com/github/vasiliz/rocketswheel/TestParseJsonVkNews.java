package com.github.vasiliz.rocketswheel;

import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.services.httpService.HttpService;
import com.github.vasiliz.rocketswheel.services.httpService.IHttpCallBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class TestParseJsonVkNews {

    private String url = "https://api.vk.com/method/newsfeed.get?filters=post&end_time&access_token=f69166c6a7a4e7d7f1a772f46e1b6164c621a220af64de0fe64afdc8f67abff2f96f511a00a2b1115dc6f";
    private IHttpCallBack mHttpService;

    @Before
    public void init() {
        mHttpService = new HttpService();

    }

    @Test
    public void testParse() throws IOException {

        final Gson gson = new GsonBuilder().create();
        final ParseNews response = gson.fromJson(mHttpService.request(url), ParseNews.class);
        assertEquals(response.getResponse().getItems().get(0).getType(), "post");
    }

}
