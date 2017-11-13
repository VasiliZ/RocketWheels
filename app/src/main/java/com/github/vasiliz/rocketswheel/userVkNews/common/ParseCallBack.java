package com.github.vasiliz.rocketswheel.userVkNews.common;

import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Response;

public interface ParseCallBack {

    void isParsed(ParseNews pParseNews);
}
