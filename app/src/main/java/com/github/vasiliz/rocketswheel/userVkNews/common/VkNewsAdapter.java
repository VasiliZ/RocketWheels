package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.tasks.DownloadImageTask;
import com.github.vasiliz.rocketswheel.tasks.OnLoadImageListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class VkNewsAdapter extends RecyclerView.Adapter<VkNewsAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Group> mGroups;

    public VkNewsAdapter(Context pContext, final List<Group> pGroups) {
        this.mGroups = pGroups;
        this.mLayoutInflater = LayoutInflater.from(pContext);
    }

    @Override
    public VkNewsAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = mLayoutInflater.inflate(R.layout.layout_block_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Group group = mGroups.get(position);
        String urlImage = group.getGroupPhoto();
        holder.mContentTextImage.setText(group.getName());
        Handler handler = new Handler(Looper.myLooper()) {

            @Override
            public void handleMessage(final Message msg) {
                holder.mContentImage.setImageBitmap((Bitmap) msg.obj);
            }
        };

        Thread thread = new Thread() {

            @Override
            public void run() {
                Bitmap bitmap = null;
                try (InputStream inputStream = new URL(urlImage).openStream()) {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (final MalformedURLException pE) {
                    pE.printStackTrace();
                } catch (final IOException pE) {
                    pE.printStackTrace();
                }

                Message message = handler.obtainMessage(1, bitmap);
                handler.sendMessage(message);
            }
        };
        thread.start();

    }

    @Override
    public int getItemCount() {
        return mGroups.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mContentTextImage;
        private ImageView mContentImage;

        public ViewHolder(final View itemView) {
            super(itemView);

            mContentImage = itemView.findViewById(R.id.photo_news_image_view);
            mContentTextImage = itemView.findViewById(R.id.title_news_text_view);

        }
    }
}
