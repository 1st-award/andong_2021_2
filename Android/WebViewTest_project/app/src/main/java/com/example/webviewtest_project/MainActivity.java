package com.example.webviewtest_project;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager2.widget.ViewPager2;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    EditText edtUrl;
    Button btnGo, btnBack, btnNext;
    WebView web;
    String nextUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // AndroidManifest.xml에서 실행했을때의 Icon이 동작하지 않아서 java코드로 대체
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.explorer);

        edtUrl = findViewById(R.id.edtUrl);
        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        web = findViewById(R.id.webView1);

        web.setWebViewClient(new CookWebViewClient());
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                web.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();
                nextUrl = web.getUrl();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(nextUrl);
            }
        });
    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}