package com.example.contextmenu_test;

import android.content.Context;
import android.graphics.*;
import android.view.*;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyGraphicView mainView;
    static float scaleX = 1, scaleY = 1, angle = 0, color = 1, satur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView = new MyGraphicView(this);
        setContentView(mainView);
        registerForContextMenu(mainView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 1, 0, "확대");
        menu.add(0, 2, 0, "축소");
        menu.add(0, 3, 0, "회전");
        menu.add(0, 4, 0, "밝게");
        menu.add(0, 5, 0, "어둡게");
        menu.add(0, 6, 0, "그레이영상");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                scaleX += 0.2f;
                scaleY += 0.2f;
                mainView.invalidate();
                break;
            case 2:
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                mainView.invalidate();
                break;
            case 3:
                angle += 20;
                mainView.invalidate();
                break;
            case 4:
                color += 0.2f;
                mainView.invalidate();
                break;
            case 5:
                color -= 0.2f;
                mainView.invalidate();
                break;
            case 6:
                if (satur == 0) satur = 1;
                else satur = 0;
                mainView.invalidate();
                break;
        }
        return true;
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int canX = this.getWidth() / 2;
            int canY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, canX, canY);
            canvas.rotate(angle, canX, canY);

            Paint paint = new Paint();
            float array[] = {color, 0, 0, 0, 0,
                    0, color, 0, 0, 0,
                    0, 0, color, 0, 0,
                    0, 0, 0, 1, 0};
            ColorMatrix cm = new ColorMatrix(array);
            if(satur == 0)  cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}