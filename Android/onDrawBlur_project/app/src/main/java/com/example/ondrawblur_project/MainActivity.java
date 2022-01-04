package com.example.ondrawblur_project;

import android.content.Context;
import android.graphics.*;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();
            BlurMaskFilter bMask;

            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);

            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);

            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);

            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
}