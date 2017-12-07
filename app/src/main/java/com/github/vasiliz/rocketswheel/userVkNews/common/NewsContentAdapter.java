package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;

import java.util.List;

public class NewsContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Item> mItems;
    private LayoutInflater mLayoutInflater;
    private List<Group> mGroups;
    private List<Profiles> mProfiles;
    private Context mContext;
    private static final int CONTENT_ITEM = 0;
    private static final int LOAD_ITEM = 1;
    private OnLoadMoreCallback mOnLoadMoreCallback;
    private boolean isLoading = false;

    public NewsContentAdapter(final Context pContext, final ParseNews pParseNews) {

        mLayoutInflater = LayoutInflater.from(pContext);
        mItems = pParseNews.getResponse().getItems();
        mGroups = pParseNews.getResponse().getGroups();
        mProfiles = pParseNews.getResponse().getProfiles();
        mContext = pContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup pParent, final int pViewType) {
        if (pViewType == CONTENT_ITEM) {
            final View view = mLayoutInflater.inflate(R.layout.post_content_layout, pParent, false);
            return new ContentBodyViewHolder(view);
        }else {
            final View view = mLayoutInflater.inflate(R.layout.item_progress_bar, pParent, false);
            return new LoadingViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position >= getItemCount() - 1 && !isLoading && mOnLoadMoreCallback != null) {


            isLoading = true;
            mOnLoadMoreCallback.onLoadMore();

        }

        if (getItemViewType(position)==CONTENT_ITEM){
            ContentBodyViewHolder contentBodyViewHolder = (ContentBodyViewHolder) holder;
            Item item = mItems.get(position);
            ConfigBodyViewHolder configBodyViewHolder = new ConfigBodyViewHolder(contentBodyViewHolder, position, item, mGroups, mProfiles, mContext);
            configBodyViewHolder.setData();
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(final int position) {
        if (mItems.get(position).getType() != "load") {
            return CONTENT_ITEM;
        } else {
            return LOAD_ITEM;
        }
    }

    public interface OnLoadMoreCallback {

        void onLoadMore();
    }

    public void setOnLoadMoreCallBack(OnLoadMoreCallback pOnLoadMoreCallBack) {
        this.mOnLoadMoreCallback = pOnLoadMoreCallBack;
    }

    public void notifyDataChanged() {
        notifyDataSetChanged();
        isLoading = false;
    }
}
