package com.github.vasiliz.rocketswheel.json.parser.user;

import java.util.List;

public class UserJsonList implements IUserList {

    private final List<IUser> mIUsers;

    public UserJsonList(List<IUser> pIUsers) {
        mIUsers = pIUsers;
    }

    @Override
    public List<IUser> mUserJsons() {
        return null;
    }
}
