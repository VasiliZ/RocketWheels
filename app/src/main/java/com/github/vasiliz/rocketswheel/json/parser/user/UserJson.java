package com.github.vasiliz.rocketswheel.json.parser.user;

import org.json.JSONObject;

public class UserJson implements IUser {

    private static final String id = "id";
    private static final String first_name = "first_name";
    private static final String last_name = "last_name";
    private static final String bdate = "bdate";
    private final JSONObject mJSONObject;

    public UserJson(JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public long getId() {
        return mJSONObject.optLong(id);
    }

    @Override
    public String getFirstName() {
        return mJSONObject.optString(first_name);
    }

    @Override
    public String getLastName() {
        return mJSONObject.optString(last_name);
    }

    @Override
    public String getBthDate() {
        return mJSONObject.optString(bdate);
    }
}
