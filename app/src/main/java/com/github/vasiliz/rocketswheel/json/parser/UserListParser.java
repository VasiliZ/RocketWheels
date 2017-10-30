package com.github.vasiliz.rocketswheel.json.parser;

import com.github.vasiliz.rocketswheel.json.parser.user.IUser;
import com.github.vasiliz.rocketswheel.json.parser.user.IUserList;
import com.github.vasiliz.rocketswheel.json.parser.user.UserJson;
import com.github.vasiliz.rocketswheel.json.parser.user.UserJsonList;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class UserListParser implements IuserListParser {

    private final String mResourse;

    public UserListParser(String pResourse) {
        mResourse = pResourse;
    }

    @Override
    public IUserList parse() throws JSONException {
        final JSONArray jsonArray = new JSONArray(mResourse);
        final List<IUser> iUsers = new ArrayList<>();

        for (int i = 0; i<jsonArray.length(); i++){
            iUsers.add(new UserJson(jsonArray.getJSONObject(i)));
        }
        return new UserJsonList(iUsers);
    }
}
