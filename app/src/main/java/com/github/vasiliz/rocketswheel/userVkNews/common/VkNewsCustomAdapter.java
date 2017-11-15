package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.imageLoader.Downloader;
import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;
import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.AttachmentNewsPhotoHolder;
import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.ViewTitleNewsHolder;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class VkNewsCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ParseNews mParseNews;
    private RecyclerView.ViewHolder viewHolder;
    private LayoutInflater mLayoutInflater;
    private Downloader mDownloader;
    private ImageManager mImageManager;
    private static final int ATTACHMENT_TYPE_POST = 1;
    private static final int ATTACHMENT_TYPE_PHOTO = 2;
    private static final int ATTACHMENT_TYPE_AUDIO = 3;
    private static final int ATTACHMENT_TYPE_LINK = 4;
    private static final int ATTACHMENT_TYPE_VIDEO = 5;
    private static final int ATTACHMENT_TYPE_DOC = 6;
    private static final int TYPE_POST_POST = 11;
    private static final int TYPE_POST_LINK = 12;
    private static final int TYPE_POST_COPY = 13;

    public VkNewsCustomAdapter(final Context pContext, final ParseNews pParseNews) {
        this.mParseNews = pParseNews;
        this.mLayoutInflater = LayoutInflater.from(pContext);
        this.mDownloader = new Downloader();
        this.mImageManager = new ImageManager();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.layout_news_body_image_post, parent, false);
        viewHolder = new AttachmentNewsPhotoHolder(view);
//        switch (viewType) {
//            case TYPE_POST_POST:
//
//                break;
        // }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final AttachmentNewsPhotoHolder attachmentNewsPhotoHolder = (AttachmentNewsPhotoHolder) holder;
        try {
            setDataToAttachmentPhotoHolder(attachmentNewsPhotoHolder, position);
        } catch (ExecutionException pE) {
            pE.printStackTrace();
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
//        switch (holder.getItemViewType()) {
//            case TYPE_POST_POST:
//
//        }

    }

    @Override
    public int getItemCount() {

        return mParseNews.getResponse().getItems().size();
    }

//    @Override
//    public int getItemViewType(final int position) {
//        System.out.println(position);
//        System.out.println(mParseNews.getResponse().getItems().get(position).getPostType());
//
//        if (mParseNews.getResponse().getItems().get(position).getPostType().equals("post")){
//            return TYPE_POST_POST;
//        }else if (mParseNews.getResponse().getItems().get(position).getPostType().equals("link")){
//            return TYPE_POST_LINK;
//        }else if (mParseNews.getResponse().getItems().get(position).getPostType().equals("copy")){
//            return TYPE_POST_COPY;
//        }
//        return -1;
//    }

    private void setDataToAttachmentPhotoHolder(final AttachmentNewsPhotoHolder pDataToAttachmentPhotoHolder, final int position) throws ExecutionException, InterruptedException {

        final Item item = mParseNews.getResponse().getItems().get(position);
        final List<Group> groupList = mParseNews.getResponse().getGroups();
        final List<Profiles> profiles = mParseNews.getResponse().getProfiles();

        if (item != null) {
            pDataToAttachmentPhotoHolder.getTextView().setText(item.getText());
            for (int i = 0; i < mParseNews.getResponse().getGroups().size(); i++) {
                if (-(item.getSouseId()) == groupList.get(i).getGid()) {
                    pDataToAttachmentPhotoHolder.setContentImage(mImageManager.getBitmap(groupList.get(i).getGroupPhoto()));
                    pDataToAttachmentPhotoHolder.setContentTextImage(groupList.get(i).getGroupName());
                }
            }
            for (int i = 0; i < mParseNews.getResponse().getProfiles().size(); i++) {
                if (item.getSouseId() == profiles.get(i).getUid()) {
                    pDataToAttachmentPhotoHolder.setContentImage(mImageManager.getBitmap(profiles.get(i).getUserPhoto()));
                    pDataToAttachmentPhotoHolder.setContentTextImage(profiles.get(i).getFirstName());
                }
            }
        }
    }

}
