package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.widget.ImageView;

import com.github.vasiliz.rocketswheel.models.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.models.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.models.vkNewsModel.Profiles;

import java.util.List;

public interface INewsHeaderModel {

    String getTitle(Item pItem, List<Group> pGroups, List<Profiles> pProfiles);

    void setTitleImage(Item pItem, List<Group> pGroups, List<Profiles> pProfiles, ImageView pImageView);

}
