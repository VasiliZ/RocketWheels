package com.github.vasiliz.rocketswheel.userAuth.model;

import com.github.vasiliz.rocketswheel.tasks.ParseTokenTask;

public class WebViewModel {

    public void loadFriends(CompliteCallBack pLoadFriendsCallBack){

    }

    public void getToken(String pUrl, CompliteCallBack pCompliteCallBack) {
        ParseTokenTask mParseTokenTask = new ParseTokenTask(pCompliteCallBack);
        mParseTokenTask.execute(pUrl);

    }
}
