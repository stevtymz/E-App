package com.example.stevtymez.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class markets extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);
        webView = (WebView) findViewById(R.id.web1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://goo.gl/maps/wad2WDJz7eN2");

    }

    public void showWebPage(View view) {
    }
}
