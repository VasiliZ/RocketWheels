package com.github.vasiliz.rocketswheel.userVkNews.view;

import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rokets.RocketView;

public interface IUserVkNewsView extends RocketView {

    void setDataNews(ParseNews pParseNews);

}
