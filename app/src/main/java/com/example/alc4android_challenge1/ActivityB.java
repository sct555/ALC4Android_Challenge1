package com.example.alc4android_challenge1;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    WebView myWebView;
    ProgressBar myProgressBar;

    String url = "https://andela.com/alc/";
    //String url = "https://www.google.co.za";
    //String url = "https://www.bloomberg.com/africa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        myWebView = findViewById(R.id.ActivityB_WebView);
        myProgressBar = findViewById(R.id.progressBar);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                Log.d("mytag","onReceivedSslError");
                //handler.proceed();
                final AlertDialog.Builder builder = new AlertDialog.Builder(ActivityB.this);
                builder.setMessage(R.string.notification_error_ssl_cert_invalid);
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.proceed();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //Log.d("mytag","onPageStarted called for url: " + url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //Log.d("mytag","shouldOverrideUrlLoading called for url: " + url);
                myProgressBar.setVisibility(View.VISIBLE);
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //Log.d("mytag","onPageFinished called for url: " + url);
                super.onPageFinished(view, url);
                myProgressBar.setVisibility(View.GONE);
            }

        });

        //Log.d("mytag","loadUrl called for url: " + url);
        myWebView.loadUrl(url);

    }
}
