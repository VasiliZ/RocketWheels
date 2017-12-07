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
//import static android.view.View.GONE;
//import static android.view.View.VISIBLE;
//
//public class NewsBodyImageModel implements IBodyModel {
//
//    private TextView mTextView;
//    private ImageView mImageView;
//    private View mViewPhoto;
//
//    public  void setContentToBodyNews(final FrameLayout contentBody, final Context pContext, final Item pItem, final ImageManager pImageManager){
//        mViewPhoto = LayoutInflater.from(pContext).inflate(R.layout.layout_news_image, contentBody, true);
//        mImageView = mViewPhoto.findViewById(R.id.photo_news_body_image_view);
//        mTextView = mViewPhoto.findViewById(R.id.text_photo_image_view);
//        mImageView.setVisibility(VISIBLE);
//        if (!(pItem.getAttachment().getAttachmentPhoto().getPhotoText().equals("")) || !(pItem.getAttachment().getAttachmentPhoto().getPhotoText() == (null))) {
//            mTextView.setText(pItem.getAttachment().getAttachmentPhoto().getPhotoText());
//        } else {
//            mTextView.setVisibility(GONE);
//        }
//        try {
//            pImageManager.getBitmap(pItem.getAttachment().getAttachmentPhoto().getBigPhoto(), mImageView);
//        } catch (final ExecutionException pE) {
//            pE.printStackTrace();
//        } catch (final InterruptedException pE) {
//            pE.printStackTrace();
//        }
//
//    }
//
//}
