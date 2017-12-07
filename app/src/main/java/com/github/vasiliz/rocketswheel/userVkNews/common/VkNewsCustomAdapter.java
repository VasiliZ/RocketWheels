//package com.github.vasiliz.rocketswheel.userVkNews.common;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.github.vasiliz.rocketswheel.R;
//import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;
//import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.NewsHolder;
//import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.NewsView;
//
//import java.util.List;
//@Deprecated
//public class VkNewsCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private final ParseNews mParseNews;
//    private RecyclerView.ViewHolder viewHolder;
//    private LayoutInflater mLayoutInflater;
//    private List<Profiles> mProfiles;
//    private Context mContext;
//    private List<Group> mGroups;
//
//    public VkNewsCustomAdapter(final Context pContext, final ParseNews pParseNews) {
//        this.mParseNews = pParseNews;
//        this.mLayoutInflater = LayoutInflater.from(pContext);
//        mContext = pContext;
//        mProfiles = pParseNews.getResponse().getProfiles();
//        mGroups = pParseNews.getResponse().getGroups();
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup pParent, final int pViewType) {
//        final View view = mLayoutInflater.inflate(R.layout.layout_head_block_news, pParent, false);
//        viewHolder = new NewsHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
//        NewsView newsView = new NewsView(mContext);
//        final NewsHolder newsHolder = (NewsHolder) holder;
//        final Item item = mParseNews.getResponse().getItems().get(position);
//        newsView.setView(holder.itemView);
//        newsView.setDataNews(item, mGroups, mProfiles);
//        newsView.setContent();
//        newsHolder.setNewsView(newsView);
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return mParseNews.getResponse().getItems().size();
//    }
//
//}
