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
//public class NewsBodyDocModel implements IBodyModel {
//
//    private View mDocViewll;
//    private TextView textDoc;
//    private ImageView docImage;
//
//
//    @Override
//    public void setContentToBodyNews(final FrameLayout contentBody, final Context pContext, final Item pItem, final ImageManager pImageManager) {
//        mDocViewll = LayoutInflater.from(pContext).inflate(R.layout.news_attachment_doc, contentBody, true);
//        textDoc = mDocViewll.findViewById(R.id.doc_text_view);
//       // textDoc.setText(pItem.getAttachment().getAttachmentDoc().getTitle());
//        docImage = mDocViewll.findViewById(R.id.thumb_doc_image_view);
//        try {
//        //    pImageManager.getBitmap(pItem.getAttachment().getAttachmentDoc().getThumb(), docImage);
//        } catch (final ExecutionException pE) {
//            pE.printStackTrace();
//        } catch (final InterruptedException pE) {
//            pE.printStackTrace();
//        }
//    }
//}
