package com.example.ex0803;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Fragment1 extends Fragment {


    // Fragment4.java파일 참고하셔서 필요한 부분만 남기고
    // onCreateView 고쳐주세요~!

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        //찾고 싶은 view가 있다면 불러올 수 있음

        //Webview를 찾아서 WebView 객체에 저장하기
        WebView wb = view.findViewById(R.id.webview);

        // webView 설정하기!
        //1.url 저장
        // 1-1. spf에 저장된 값 가져오기~~
        String address = getActivity()
                .getSharedPreferences("mySPF", Context.MODE_PRIVATE)//SharePreferences객체가져오기
                .getString("address","");//첫실행인지 아닌지 알 수 있는 곳 defValue

        //key : 데이터를 꺼낼 때 사용하는 키값!
        //defValue (Default Value) : 키값에 해당하는 데이터가 없을 때 사용할 기본값(요걸로 첫실행 여부 감지)

        //2.자바스크립트 활성화
        WebSettings webSettings = wb.getSettings();//세팅할 수 있는 개체 찾아오기
        webSettings.setJavaScriptEnabled(true);//자바스크립트가 보일 수 있도록 활성화하는 명령어

        //3.설정적용!!
        wb.loadUrl(address);
        wb.setWebViewClient(new WebViewClient());

        //4. http 통신규약 사용 옵션 설정하기
        //manifests 파일 열어서 코드 추가


        return view;
    }
}