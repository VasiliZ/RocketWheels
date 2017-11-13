package com.github.vasiliz.rocketswheel.userVkNews.model;

import com.github.vasiliz.rocketswheel.tasks.ParseUserNewsTask;
import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;

public class UserVkNewsModel implements IUserVkNewsModel {

    @Override
    public void getNewsVk(final String url, final ParseCallBack pICompleteCallBack) {
        final ParseUserNewsTask parseUserNewsTask = new ParseUserNewsTask(pICompleteCallBack);
        parseUserNewsTask.execute(url);
    }

}
