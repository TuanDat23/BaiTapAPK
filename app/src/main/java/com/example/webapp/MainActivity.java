package com.example.webapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.addJavascriptInterface(new MyJavaScriptInterface(), "Android");

        myWebView.loadUrl("file:///android_asset/index.html");
    }

    public class MyJavaScriptInterface {
        @JavascriptInterface
        public String getPersonalInfo() {
            return "Họ tên: Vi Tuấn Đạt\nMSSV: K215480106088\nLớp: CNTT";
        }
    }
}
