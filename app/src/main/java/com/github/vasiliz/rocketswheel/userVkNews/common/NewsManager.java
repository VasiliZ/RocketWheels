package com.github.vasiliz.rocketswheel.userVkNews.common;

import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;

import java.util.List;

public class NewsManager {

    private ParseNews mParseNews;


    public void viewNews(ParseNews pParseNews){

        List<Item> items = pParseNews.getResponse().getItems();

        for (int i = 0;i<items.size();i++) {

            if ("post".equals(items.get(i).getType())){

            }
        }
    }

}
