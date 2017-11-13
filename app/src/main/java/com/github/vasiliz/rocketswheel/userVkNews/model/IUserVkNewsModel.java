package com.github.vasiliz.rocketswheel.userVkNews.model;

import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;

public interface IUserVkNewsModel {

    void getNewsVk(String url, ParseCallBack pICompliteCallBack);

}
