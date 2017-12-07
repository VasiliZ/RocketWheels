//package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.github.vasiliz.rocketswheel.R;
//import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
//
//import java.util.concurrent.ExecutionException;
//
//public class NewsBodyVideoModel implements IBodyModel {
//
//    private ImageView mImageView;
//    private View mVideoView;
//
//    public void setContentToBodyNews(final FrameLayout contentBody, final Context pContext, final Item pItem, final ImageManager pImageManager) {
//        mVideoView = LayoutInflater.from(pContext).inflate(R.layout.news_attachment_video, contentBody, true);
//        mImageView = mVideoView.findViewById(R.id.video_news_image_view);
//        try {
//            pImageManager.getBitmap(pItem.getAttachment().getAttachmentVideo().getImageVideo(), mImageView);
//        } catch (ExecutionException pE) {
//            pE.printStackTrace();
//        } catch (InterruptedException pE) {
//            pE.printStackTrace();
//        }
//    }
//
//}
