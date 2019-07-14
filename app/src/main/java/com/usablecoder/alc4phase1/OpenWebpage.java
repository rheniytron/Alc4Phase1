package com.usablecoder.alc4phase1;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class OpenWebpage extends AppCompatActivity {
    private WebView webView = null;
    private ProgressBar progressBar;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_webpage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new MyWebviewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://www.andela.com/alc/");


        progressBar = (ProgressBar) toolbar.findViewById(R.id.loading_progress_bar);
        imageButton = (ImageButton) toolbar.findViewById(R.id.refreash_ic);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void go_home(View view) {
        finish();
    }

    public void refresh_page(View view) {
        webView.reload();

        progressBar.setVisibility(View.VISIBLE);
        imageButton.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);
                imageButton.setVisibility(View.VISIBLE);

            }
        }, 3000);
    }


    private class MyWebviewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    progressBar.setVisibility(View.GONE);
                    imageButton.setVisibility(View.VISIBLE);

                }
            }, 3000);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    progressBar.setVisibility(View.GONE);
                    imageButton.setVisibility(View.VISIBLE);

                }
            }, 3000);

        }
    }

}


