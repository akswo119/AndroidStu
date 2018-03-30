package com.example.chap04_14_webbrowser;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Handler handler = new Handler();
    Button loadButton;
    EditText urlInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebBrowserClint());
        webView.addJavascriptInterface(new JavascriptMethod(), "sample");

        webView.loadUrl("file:///android_asset/www/sample.html");
        //webView.loadUrl("file:///C:/Users/BK/AndroidStudioProjects/AndroidStu/chap04_14_webbrowser/src/main/assets/www/sample.html");

        urlInput = (EditText) findViewById(R.id.urlInput);

        loadButton = (Button) findViewById(R.id.btnLoad);
        loadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                //webView.loadUrl("file:///android_asset/www/sample.html");
                //webView.loadUrl("file:///C:/Users/BK/AndroidStudioProjects/AndroidStu/chap04_14_webbrowser/src/main/assets/www/sample.html");
                webView.setWebViewClient(new WebClient());
                webView.loadUrl(urlInput.getText().toString());
            }
        });

    }


    final class WebBrowserClint extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();;
            return true;
        }
    }

    final class JavascriptMethod {
        JavascriptMethod(){}
        @android.webkit.JavascriptInterface
        public void clickOnFace() {
            handler.post(new Runnable() {
                public void run() {

                    loadButton.setText("클릭후 열기");
                    webView.loadUrl("javascript:changeFace()");
                }
            });

        }
    }

    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return  true;

        }
    }
}
