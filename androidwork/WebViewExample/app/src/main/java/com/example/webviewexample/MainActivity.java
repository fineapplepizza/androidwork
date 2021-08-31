package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView; //webView
    private String url="http://www.naver.com"; //자기가 쓰고 싶은 주소

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView); //webView의 아이디값 불러오기
        webView.getSettings().setJavaScriptEnabled(true);//자바스크립트라는 부가적인 언어를 허용하느냐 true
        webView.loadUrl(url);//특정url주소를 틀어라
        webView.setWebChromeClient(new WebChromeClient());//구글 크롬환경에 맞춤셋팅
        webView.setWebViewClient(new WebViewClientClass());


    }
    //추가적으로 핸드폰에서 뒤로가기 버튼을 눌렀을때 webView가 정상적으로 종료되게 해주야함
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //안드로이들의 key들을 입력했을 때 어떤 동작을 해줘라
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){ //뒤로 갈 수 있게 되면
            //KEYCODE_BACK -뒤로가기버튼,
            webView.goBack();//웹뷰를 뒤로가게 해라

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //shouldOverrideUrlLoading-현재페이지에 url을 읽어오는 메소드(새창을 읽을 수 있고 특정페이지에서 특수한 기능을 넣을 수 있음)
            view.loadUrl(url);
            return true;
        }
    }
}