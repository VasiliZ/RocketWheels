package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.widget.ImageView;

import com.github.vasiliz.rocketswheel.imagesLoader.ImageLoader;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;

import java.util.List;

public class NewsHeaderModel implements INewsHeaderModel {

    public String getTitle(final Item pItem, final List<Group> pGroups, final List<Profiles> pProfiles) {
        if (pItem != null) {
            for (int i = 0; i < pGroups.size(); i++) {
                if (-(pItem.getSouseId()) == pGroups.get(i).getGid()) {
                    return pGroups.get(i).getGroupName();
                }
            }
            for (int i = 0; i < pProfiles.size(); i++) {
                if (pItem.getSouseId() == pProfiles.get(i).getUid()) {
                    return pProfiles.get(i).getFirstName() + " " + pProfiles.get(i).getLastName();
                }
            }
        }
        return null;
    }

    @Override
    public void setTitleImage(final Item pItem, final List<Group> pGroups, final List<Profiles> pProfiles, final  ImageView pImageView) {
        try {
            if (pItem != null) {
                for (int i = 0; i < pGroups.size(); i++) {
                    if (-(pItem.getSouseId()) == pGroups.get(i).getGid()) {

                            ImageLoader.getInstance().load(pGroups.get(i).getPhotoGroup()).into(pImageView);
                        //    pImageManager.getBitmap(pGroups.get(i).getPhotoGroup(), pImageView);
                    }
                }
                for (int i = 0; i < pProfiles.size(); i++) {
                    if (pItem.getSouseId() == pProfiles.get(i).getUid()) {

                            ImageLoader.getInstance().load(pProfiles.get(i).getUserPhoto()).into(pImageView);
                          //   pImageManager.getBitmap(pProfiles.get(i).getUserPhoto(), pImageView);
                    }
                }
            }

        } catch (NullPointerException pE) {
            pE.fillInStackTrace();
        }
    }
}
