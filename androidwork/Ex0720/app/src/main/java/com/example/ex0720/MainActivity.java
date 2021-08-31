package com.example.ex0720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Activity 구동 준비!
        setContentView(R.layout.activity_main); //Java파일과 xml파일을 연결!
        // 리소스 폴더 아래의 layout폴더의 activity_main이라는 레이아웃 화면에 그려라

        // findViewById할 때 setContentView 된 xml안에서 찾음!!
        //1.만약에 main.xml에도 btn1이 있고! kakao.xml에도 btn1이 있으며 뭘 찾아옴?? 현재 setContentView된 곳
        // 2. setContentView가 없는 상황에서 findViewById하면? 에러가 남
    }
}