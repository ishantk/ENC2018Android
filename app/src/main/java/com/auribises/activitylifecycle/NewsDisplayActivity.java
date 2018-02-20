package com.auribises.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsDisplayActivity extends AppCompatActivity {

    WebView webView;

    void initViews(){

        getSupportActionBar().setTitle("Showing News");

        webView = findViewById(R.id.webView);

        Intent rcv = getIntent();

        String url = rcv.getStringExtra("keyUrl");

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_display);
        initViews();
    }
}
