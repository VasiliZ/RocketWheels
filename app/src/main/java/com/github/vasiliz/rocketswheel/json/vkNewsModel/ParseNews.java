package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class ParseNews {

    @SerializedName("response")
    private Response mResponse;

    public ParseNews(final Response pResponse) {
        mResponse = pResponse;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(final Response pResponse) {
        mResponse = pResponse;
    }
}
