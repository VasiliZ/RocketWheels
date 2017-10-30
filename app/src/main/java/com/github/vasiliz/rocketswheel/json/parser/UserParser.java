package com.github.vasiliz.rocketswheel.json.parser;

import com.github.vasiliz.rocketswheel.json.parser.IUserParser;
import com.github.vasiliz.rocketswheel.json.parser.user.IUser;
import com.github.vasiliz.rocketswheel.json.parser.user.UserJson;

import org.json.JSONException;
import org.json.JSONObject;

public class UserParser implements IUserParser {

    private final String mResourse;

    public UserParser(String pResourse) {
        mResourse = pResourse;
    }

    @Override
    public IUser parse() throws JSONException {
        final JSONObject jsonObject = new JSONObject(mResourse);
        return new UserJson(jsonObject);
    }
}
