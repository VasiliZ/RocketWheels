package com.github.vasiliz.rocketswheel;

import com.github.vasiliz.rocketswheel.services.httpService.HttpService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestParseJsonVkNews {

    private String url = "https://api.vk.com/method/newsfeed.get?filters=post&end_time&access_token=f69166c6a7a4e7d7f1a772f46e1b6164c621a220af64de0fe64afdc8f67abff2f96f511a00a2b1115dc6f";
    private HttpService mHttpService;
    private JsonParser mJsonParser;

    @Before
    public void init() {
        mHttpService = new HttpService();

    }

    @Test
    public void testParse() throws IOException {

       JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(mHttpService.request(url)).getAsJsonObject();
        JsonArray jsonElements =   jsonObject.getAsJsonArray("items");
        for (JsonElement jsonElement : jsonElements){
            JsonObject object = jsonElement.getAsJsonObject();
            object.get("type");
        }

    }

}
