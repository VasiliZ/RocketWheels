package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.github.vasiliz.rocketswheel.imageLoader.Downloader;
import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;

import java.util.List;

public interface INewsHeaderModel {

    String getTitle(Item pItem, List<Group> pGroups, List<Profiles> pProfiles);

    void setTitleImage(Item pItem, List<Group> pGroups, List<Profiles> pProfiles, ImageView pImageView);

}
