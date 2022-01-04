package com.example.remainshapetest_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, RECT = 3, RED = Color.RED, GREEN = Color.GREEN, BLUE = Color.BLUE;
    static int currentShape = LINE, currentColor = RED;
    static List<MyShape> shapeList = new ArrayList<MyShape>();
    MyGraphicView myGraphicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myGraphicView = new MyGraphicView(this);
        setContentView(myGraphicView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        menu.add(0, 7, 0, "되돌리기");

        SubMenu subMenu = menu.addSubMenu("색상 변경 >>");
        subMenu.add(0, 4, 0, "빨강");
        subMenu.add(0, 5, 0, "초록");
        subMenu.add(0, 6, 0, "파랑");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                currentShape = LINE;
                break;
            case 2:
                currentShape = CIRCLE;
                break;
            case 3:
                currentShape = RECT;
                break;
            case 4:
                currentColor = RED;
                break;
            case 5:
                currentColor = GREEN;
                break;
            case 6:
                currentColor = BLUE;
                break;
            case 7:
                shapeList.remove(shapeList.size()-1);
                myGraphicView.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyShape {
        int shapeType;
        int startX, startY, stopX, stopY;
        int color;

        public MyShape(int shapeType, int startX, int startY, int stopX, int stopY, int color) {
            this.shapeType = shapeType;
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.color = color;
        }
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    System.out.println("start draw: " + startX + " " + startY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    System.out.println("move pos: " + stopX + " " + stopY);
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    shapeList.add(new MyShape(currentShape, startX, startY, stopX, stopY, currentColor));
                    System.out.println("stop draw: " + stopX + " " + stopY);
                    this.invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(currentColor);

            // 현재 그리고 있는 도형을 그려줌
            switch (currentShape) {
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case RECT:
                    canvas.drawRect(startX, startY, stopX, stopY, paint);
                    break;
            }

            // 과거에 그렷던 그림을 그려줌
            for (MyShape shape : shapeList) {
                paint.setColor(shape.color);
                switch (shape.shapeType) {
                    case LINE:
                        canvas.drawLine(shape.startX, shape.startY, shape.stopX, shape.stopY, paint);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow(shape.stopX - shape.startX, 2) + Math.pow(shape.stopY - shape.startY, 2));
                        canvas.drawCircle(shape.startX, shape.startY, radius, paint);
                        break;
                    case RECT:
                        canvas.drawRect(shape.startX, shape.startY, shape.stopX, shape.stopY, paint);
                        break;
                }
            }
            System.out.println("finish");
        }
    }
}