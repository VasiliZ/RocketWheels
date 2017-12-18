package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.content.Context;
import android.widget.FrameLayout;

import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
@Deprecated
public interface IBodyModel {

    void setContentToBodyNews(final FrameLayout contentBody, final Context pContext, final Item pItem, final ImageManager pImageManager);

}
