package com.example.qiaotian.onlinetreatapp.WebViewActivity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.qiaotian.onlinetreatapp.R;

public class Gynecology extends AppCompatActivity {

    WebView mWebview;
    WebSettings mWebSettings;
    TextView mtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gynecology);


        mWebview = (WebView) findViewById(R.id.webView1);

        //endLoading = (TextView) findViewById(R.id.text_endLoading);

        mtitle = (TextView) findViewById(R.id.title);

        mWebSettings = mWebview.getSettings();

        mWebview.loadUrl("http://www.zdsfy.net/page/10.html");

        mWebview.onResume();
        mWebSettings.setJavaScriptEnabled(true);

        mWebview.canGoBackOrForward(-41);


//设置自适应屏幕，两者合用
        mWebSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        mWebSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        mWebview.setWebChromeClient(new WebChromeClient() {


            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("标题在这里");

            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {


                } else if (newProgress == 100) {


                }
            }
        });


        //设置WebViewClient类
        mWebview.setWebViewClient(new WebViewClient() {
            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {


            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {


            }
        });
    }

    //点击返回上一页面而不是退出浏览器


    //销毁Webview

    //    protected void onDestroy() {
//        if (mWebview != null) {
//            mWebview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
//            mWebview.clearHistory();
//
//            ((ViewGroup) mWebview.getParent()).removeView(mWebview);
//            mWebview.destroy();
//            mWebview = null;
//        }
//        super.onDestroy();
//    }
    public boolean canGoForward(){

        return false;
    }
}

