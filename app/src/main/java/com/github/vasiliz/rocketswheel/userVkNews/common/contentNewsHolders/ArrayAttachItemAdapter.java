//package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.github.vasiliz.rocketswheel.R;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Attachments;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
//@
//public class ArrayAttachItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private final Item mItem;
//    private LayoutInflater mLayoutInflater;
//
//    public ArrayAttachItemAdapter(Item pItem, Context pContext) {
//        mItem = pItem;
//        mLayoutInflater = LayoutInflater.from(pContext);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
//
//        final View imageArray = mLayoutInflater.inflate(R.layout.layout_news_image, parent, false);
//
//        return new PhotoRecyclerHolder(imageArray);
//    }
//
//    @Override
//    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
//        PhotoRecyclerHolder photoRecyclerHolder = (PhotoRecyclerHolder) holder;
//        Attachments attachments = mItem.getAttachments().get(position);
//        SetDataPhoto setDataPhoto = new SetDataPhoto(attachments, photoRecyclerHolder);
//        setDataPhoto.setData();
//    }
//
//    @Override
//    public int getItemCount() {
//        return mItem.getAttachments().size();
//    }
//}
