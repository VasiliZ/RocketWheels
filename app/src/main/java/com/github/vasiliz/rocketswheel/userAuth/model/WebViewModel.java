package com.github.vasiliz.rocketswheel.userAuth.model;

import com.github.vasiliz.rocketswheel.tasks.ParseTokenTask;

public class WebViewModel {

    public void getToken(String pUrl, ICompliteCallBack pICompliteCallBack) {
        ParseTokenTask mParseTokenTask = new ParseTokenTask(pICompliteCallBack);
        mParseTokenTask.execute(pUrl);

    }
}
