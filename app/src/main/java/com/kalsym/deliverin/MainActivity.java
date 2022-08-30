package com.kalsym.deliverin;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String URL = "https://www.deliverin.my";
    private WebView webView;
    private boolean isLoading = true;
    private Handler handler;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        webView = findViewById(R.id.webView);

        openURL(URL);

        webView.setVisibility(View.INVISIBLE);
        
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.INVISIBLE);
            }
        }, 7000);

    }

    private void openURL(String URL) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        webView.loadUrl(URL);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }
}