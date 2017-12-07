package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
@Deprecated
public class DrawStringOnBitmap {

    public static Bitmap drawOnBitmap(Bitmap pBitmap, String ext) {
        Bitmap bitmap = pBitmap;
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap,0,0,null);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawText(ext, 100, 50, paint);
        return bitmap;
    }

}
