package com.example.ondrawimage2_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    public static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.small);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            // 그림 회전
            canvas.rotate(45, cenX, cenY);
            canvas.drawBitmap(picture, picX, picY, null);

            // 그림 이동
            canvas.translate(-150, 200);
            canvas.drawBitmap(picture, picX, picY, null);

            // 그림 확대
            canvas.scale(2, 2, cenX, cenY);
            canvas.drawBitmap(picture, picX, picY, null);

            // 그림 기울이기
            canvas.skew(0.3f, 0.3f);
            canvas.drawBitmap(picture, picX, picY, null);

            picture.recycle();
        }
    }
}