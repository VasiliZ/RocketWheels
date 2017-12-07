//package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
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
//public class NewsBodyLinkModel implements IBodyModel {
//
//    private View mLinkView;
//    private ImageView mLinkImageView;
//    private TextView mLinkTextView;
//
//    @Override
//    public void setContentToBodyNews(final FrameLayout contentBody, final Context pContext, final Item pItem, final ImageManager pImageManager) {
//        mLinkView = LayoutInflater.from(pContext).inflate(R.layout.news_attachment_link, contentBody, true);
//        mLinkTextView = mLinkView.findViewById(R.id.link_news_text_view);
//        mLinkTextView.setText(pItem.getAttachment().getAttachmentLink().getTitle());
//        mLinkImageView = mLinkView.findViewById(R.id.link_news_src_image_view);
//        try {
//            pImageManager.getBitmap(pItem.getAttachment().getAttachmentLink().getImageSrcLink(), mLinkImageView);
//        } catch (ExecutionException pE) {
//            pE.printStackTrace();
//        } catch (InterruptedException pE) {
//            pE.printStackTrace();
//        }
//
//        mLinkImageView.setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.addCategory(Intent.CATEGORY_BROWSABLE);
//            intent.setData(Uri.parse(pItem.getAttachment().getAttachmentLink().getLink()));
//            pContext.startActivity(intent);
//        });
//    }
//}
