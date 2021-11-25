package com.example.menutest2_project;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RelativeLayout baseLayout;
    EditText setInputRotate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        baseLayout = (RelativeLayout)findViewById(R.id.RelativeLayout);
        setInputRotate = (EditText)findViewById(R.id.EditText1);
        imageView = (ImageView)findViewById(R.id.ImageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnRotate:
                imageView.setRotation(Float.parseFloat(setInputRotate.getText().toString()));
                return true;
            case R.id.pic1:
                imageView.setImageResource(R.drawable.pic1);
                item.setChecked(true);
                return true;
            case R.id.pic2:
                imageView.setImageResource(R.drawable.pic2);
                item.setChecked(true);
                return true;
            case R.id.pic3:
                imageView.setImageResource(R.drawable.pic3);
                item.setChecked(true);
                return true;
        }
        return false;
    }
}