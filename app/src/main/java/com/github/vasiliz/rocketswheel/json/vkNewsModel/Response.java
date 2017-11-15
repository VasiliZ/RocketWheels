package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("profiles")
    private List<Profiles> mProfiles;
    @SerializedName("groups")
    private List<Group> mGroups;

    public Response() {
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(final List<Item> pItems) {
        mItems = pItems;
    }

    public List<Profiles> getProfiles() {
        return mProfiles;
    }

    public void setProfiles(final List<Profiles> pProfiles) {
        mProfiles = pProfiles;
    }

    public List<Group> getGroups() {
        return mGroups;
    }

    public void setGroups(final List<Group> pGroups) {
        mGroups = pGroups;
    }
}
