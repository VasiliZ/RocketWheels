package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.imageLoader.Downloader;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.ViewTitleNewsHolder;

import java.util.List;
@Deprecated
public class VkNewsAdapter extends RecyclerView.Adapter<ViewTitleNewsHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Group> mGroups;
    private Downloader mDownloader;

    public VkNewsAdapter(final Context pContext, final List<Group> pGroups) {
        this.mGroups = pGroups;
        this.mLayoutInflater = LayoutInflater.from(pContext);
        this.mDownloader = new Downloader();
    }

    @Override
    public ViewTitleNewsHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = mLayoutInflater.inflate(R.layout.layout_activity_login, parent, false);
        return new ViewTitleNewsHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewTitleNewsHolder holder, final int position) {

        final Group group = mGroups.get(position);
        holder.setContentTextImage(group.getGroupName());
        //mDownloader.downloadImage(group.getPhotoGroup(), holder.getContentImage());
    }

    @Override
    public int getItemCount() {
        return mGroups.size();
    }

}
